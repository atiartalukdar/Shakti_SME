package bp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.R;
import com.theartofdev.edmodo.cropper.CropImage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import rettrofit.APIManager;

/**
 * Created by Atiar Talukdar on 7/18/2019.
 */
public class Utils {
    private static final String TAG = "Utils.class Atiar - ";

    public static void checkForceUpdate(){
        AppUpdater appUpdater = new AppUpdater(MyApplication.getContext())
                .setDisplay(Display.DIALOG)
                .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                .setButtonDoNotShowAgain(null)
                .setButtonDismiss(null)
                .setCancelable(false)
                ;

        appUpdater.start();

    }
    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getVersionCode(){
        String versionCode = "";
        try {
            PackageInfo pInfo = MyApplication.getContext().getPackageManager().getPackageInfo(MyApplication.getContext().getPackageName(), 0);
            versionCode = pInfo.versionName;
            return versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionCode;
    }

    public static String getVersionName(){
        String versionName = "";
        try {
            PackageInfo pInfo = MyApplication.getContext().getPackageManager().getPackageInfo(MyApplication.getContext().getPackageName(), 0);
            versionName = pInfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionName;
    }

    public static String getServerType(){
        String apiStatus = "";
        String[] parts = APIManager.BASE_URL_NEW.split(":");
        if (parts[2].trim().toLowerCase().equals("8082")){
            return "Demo";
        }
        return apiStatus;
    }


    public static Uri photoURI;
    private static File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = MyApplication.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        return image;
    }
    public static void captureImage(Activity activity, int requestCode) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(MyApplication.getContext().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(MyApplication.getContext(),
                        "com.sfdw.shaktisme.provider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                activity.startActivityForResult(takePictureIntent, requestCode);
            }
        }
    }
    public static Bitmap getBitMapImageFromIntent(Activity activity, int requestCode, int resultCode, Intent data){
        CropImage.ActivityResult result = CropImage.getActivityResult(data);
        if (result != null){
            if (resultCode == activity.RESULT_OK) {
                Uri resultUri = result.getUri();
                try {
                    return decodeSampledBitmapFromUri(resultUri,500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

        return null;
    }
    public static Bitmap decodeSampledBitmapFromUri(Uri uri,
                                                    int minReqSize) throws FileNotFoundException {

        BitmapFactory.Options options = new BitmapFactory.Options();
        // First decode with inJustDecodeBounds=true to check dimensions
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(MyApplication.getContext().getContentResolver()
                .openInputStream(uri), null, options);
        // The new size we want to scale to
        final int REQUIRED_SIZE = minReqSize;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = options.outWidth, height_tmp = options.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
                    || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }
        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;

        return BitmapFactory.decodeStream(MyApplication.getContext().getContentResolver()
                .openInputStream(uri), null, o2);
    }

    public static AlertDialog alert;
    public static AlertDialog showDialog(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(message)
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alert = builder.create();
        alert.show();
        return alert;
    }
    public static KProgressHUD showProgressDialog(Activity activity, String description){
        KProgressHUD kProgressHUD = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(activity.getResources().getString(R.string.pleaseWait))
                .setDetailsLabel(description)
                .setCancellable(true)
                .setAnimationSpeed(1)
                .setDimAmount(0.5f)
                .show();
        return kProgressHUD;
    }

    public static String convetToJsonString(Object object) {

        Gson gsonBuilder = new GsonBuilder().create();
        Log.e(TAG, gsonBuilder.toJson(object));
        return gsonBuilder.toJson(object);

    }

    public static Uri getImageUriFromBitMap(Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        String path = MediaStore.Images.Media.insertImage(MyApplication.getContext().getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public static String getRealPathFromURI(Context context, Uri uri) {
        String path = "";
        if (context.getContentResolver() != null) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }

    public static void showError(String tag, String errorMessage) {
        Toast.makeText(MyApplication.getContext(), errorMessage, Toast.LENGTH_SHORT).show();
        Log.e(tag, errorMessage);
    }

    public static int getTempLeadID() {
        return (int) (Math.random() * 100 + 1);
    }

    public static Map<String,String> convertToHashMap(Object object) throws JSONException {

        Gson gsonBuilder = new GsonBuilder().create();
        JSONObject mJSONObject = new JSONObject(gsonBuilder.toJson(object));
        Map<String, String> params = new HashMap<String, String>();

        try {
            Iterator<?> keys = mJSONObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = mJSONObject.getString(key);
                params.put(key, value);
            }
        } catch (Exception xx) {
            xx.toString();
        }

        return  params;
    }

    public static String convertToBase64(Bitmap bitmap)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
    }
    public static String encodeImage(Bitmap bm)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }

    public static int differenceValue = 1000000;

    public static int findDifference(int a, int b){
        return Math.abs(a-b);
    }

    public static long findDifference(long a, long b){
        return Math.abs(a-b);
    }

    public static String formatNumber(int number){
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number);
    }

    public static String formatNumber(long number){
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number);
    }

    public static String formatNumber(Double number){
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number);
    }

    public static String formatNumber(String number){
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(Integer.parseInt(number));
    }

    public static int getNumberFromEditText(EditText editText){
        try {
            return Integer.parseInt(editText.getText().toString());
        }catch (Exception e){
            return 0;
        }
    }

    public static long getLongFromEditText(EditText _edittext){
        try{
            return Long.parseLong(_edittext.getText().toString());
        }catch (Exception e){
            return 0l;
        }

    }

    public static boolean isNullOrEmptyOrWhiteSpace(String value){
        if(value == null){
            return false;
        }
        if(value == ""){
            return false;
        }
        if(value.isEmpty()){
            return false;
        }
        if(value.length() == 0){
            return false;
        }
        return true;
    }


    public static boolean checkEdidtext(EditText editText){
        if (editText.getText() == null || editText.getText().equals("")) {
            setError(editText, "Required");
            return false;
        }
        return true;
    }

    public static void setError(EditText editText, String errorMessage) {
        Vibrator vibe = (Vibrator) MyApplication.getContext().getSystemService(Context.VIBRATOR_SERVICE);
        editText.setError(errorMessage);
        editText.startAnimation(shakeError());
        vibe.vibrate(300);
        editText.setTextColor(MyApplication.getContext().getResources().getColor(R.color.errorColor));
    }

    private static TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(7));
        return shake;
    }

    public static boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


}
