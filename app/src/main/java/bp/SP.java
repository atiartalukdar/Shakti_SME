package bp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;

import com.sfdw.shaktisme.BuildConfig;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import locationprovider.davidserrano.com.LocationProvider;

public class SP {
    private static final String TAG = MyApplication.class.getSimpleName() + "Atiar= ";
    private static final String PREFS_NAME = "pref";
    private static final String key_leadID = "leadID";
    private static final String key_lat = "lat";
    private static final String key_lang = "lang";
    private static final String key_address = "address";
    private static final String key_totalMembers = "totalMembers";
    private static final String key_profileImage = "pro_image";

    private static boolean setPreference(String key, String value) {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    private static String getPreference(String key) {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, "none");
    }

    private static void removeSingleItem(String keyToRemove) {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        settings.edit().remove(keyToRemove).commit();
    }

    private static void removeAllItem() {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }

    //For generating and using of lead id
    //if lead id once generate and didn't submit the lead then it will remain stored in shared preferences
    //once lead is submitted lead shared preferences lead id will removed and new lead id will be called from api.
    public static void setLeadID(String leadID) {
        setPreference(key_leadID, leadID);
    }

    public static String getLeadID() {
        return getPreference(key_leadID);
    }

    public static void removeLeadID() {
        removeSingleItem(key_leadID);
    }

    public static boolean locationStatusCheck(Activity activity) {
        boolean status = true;
        final LocationManager manager = (LocationManager) MyApplication.getContext().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps(activity);
            status = false;
        }
        return  status;
    }

    private static void buildAlertMessageNoGps(Activity activity) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        Intent i = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        MyApplication.getContext().startActivity(i);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                        buildAlertMessageNoGps(activity);
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
    /**
     * Returns the unique identifier for the device
     *
     * @return unique identifier for the device
     */
    @SuppressLint("MissingPermission")
    public static String getDeviceIMEI() {
        String deviceUniqueIdentifier = null;
        TelephonyManager tm = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (null != tm) {
            deviceUniqueIdentifier = tm.getDeviceId();
        }
        if (null == deviceUniqueIdentifier || 0 == deviceUniqueIdentifier.length()) {
            deviceUniqueIdentifier = Settings.Secure.getString(MyApplication.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return deviceUniqueIdentifier;
    }

    @SuppressLint("MissingPermission")
    public static String getMyPhoneNO() {
        String mPhoneNumber;
        TelephonyManager tMgr = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tMgr.getLine1Number() != null){
            mPhoneNumber = tMgr.getLine1Number();
        }else {
            mPhoneNumber = tMgr.getSimSerialNumber();
        }
        return mPhoneNumber;
    }

    public static String getAppVersion(){
        int versionCode = BuildConfig.VERSION_CODE;
        String versionName = BuildConfig.VERSION_NAME;
        return "vCode: " + versionCode + " vName: "+ versionName;
    }

    private static String getAddressFromLatLang(float latitude, float longitude) throws IOException {
        String perfectAddress = "";
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(MyApplication.getContext(), Locale.getDefault());

        addresses = geocoder.getFromLocation(latitude, longitude, 5); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

        for (int i=0;i<5;i++){
            address = addresses.get(i).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(i).getLocality();
            String state = addresses.get(i).getAdminArea();
            String country = addresses.get(i).getCountryName();
            String postalCode = addresses.get(i).getPostalCode();
            String knownName = addresses.get(i).getFeatureName(); // Only if available else return NULL
            Log.e(TAG + i+ ": ",address);


            if (address.contains("Rd No.") || address.contains("Rd No") || address.contains("Road No.") || address.contains("Road")){
                if (!address.contains("Unnamed Road")){
                    perfectAddress = address;
                    break;
                }

            }

            Log.e(TAG + i +": ", "City: "+city + " state: "+ state + " Country: " + country + " postcode : "+ postalCode + " knownName: "+ knownName);

        }
        if (perfectAddress.equals("") || perfectAddress == null){
            perfectAddress = addresses.get(0).getAddressLine(0);
        }
        return perfectAddress.replace(", Bangladesh", "").replace("Bangladesh","");
    }

    public static void updateLocation(){
        locationProvider.requestLocation();
    }

    public static void setLocation(float latitude, float longitude){
        setPreference(key_lat,latitude+"");
        setPreference(key_lang,longitude+"");

        try {
            setPreference(key_address,getAddressFromLatLang(latitude , longitude));
        }catch (Exception e){
            setPreference(key_address,"");
        }
    }

    public static String getLatitude(){
        return getPreference(key_lat);
    }

    public static String getLongitude(){
        return getPreference(key_lang);
    }

    public static String getAddress(){
        return getPreference(key_address);
    }

    public static void setTotalMember(String totalMembers){
        setPreference(key_totalMembers,totalMembers);
    }

    public static String getTotalMembers(){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key_totalMembers, "");    }

    //create a location callback
    static LocationProvider.LocationCallback callback = new LocationProvider.LocationCallback() {
        @Override
        public void onNewLocationAvailable(float lat, float lon) {
            //location update
            Log.e("Atiar - ", "onNewLocationAvailable " + lat + " - " +lon );
            SP.setLocation(lat,lon);
        }

        @Override
        public void locationServicesNotEnabled() {
            //failed finding a location

        }

        @Override
        public void updateLocationInBackground(float lat, float lon) {
            //if a listener returns after the main locationAvailable callback, it will go here

        }

        @Override
        public void networkListenerInitialised() {
            //when the library switched from GPS only to GPS & network
            //Log.e("Atiar - ", "networkListenerInitialised " + lat + " - " +lon );

        }

        @Override
        public void locationRequestStopped() {
            Log.e("Atiar - ", "locationRequestStopped " );

        }
    };

    //initialise an instance with the two required parameters
    public static LocationProvider locationProvider = new LocationProvider.Builder()
            .setContext(MyApplication.getContext())
            .setListener(callback)
            .create();
}
