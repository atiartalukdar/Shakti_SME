package bp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;

import dataModel.LoginData;
import dataModelNew.LoginDM;


/**
 * Created by Atiar on 5/23/18.
 */

public class Session {

    private static final String PREFS_NAME = "preferenceName";
    private static final String key_login = "sessionLogin";
    private static final String key_login_time = "sessionLoginTime";
    private static final String key_login_data = "sessionLoginData";
    private static final String key_login_isLoggedIn = "sessionLoginIsLoggedIn";

    /*****************************//* Strat shared preferences *******************************/

    public static boolean setPreference(String key, String value) {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getPreference(Context context, String key) {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, "None");
    }

    public static boolean setPreferenceInt(Context context, String key, int value) {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static int getPreferenceInt(Context context, String key) {
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, 0);
    }


    /*****************************//* End shared preferences *//******************************/



    //============================  ##Session Data ##  ===========================//

    // public methods
    public static boolean createSeassion(String userID, LoginData loginData){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(loginData);
        editor.putString(key_login_data, json);
        editor.putString(key_login, userID);
        editor.putString(key_login_time,TimeUtils.getCurrentTime());
        editor.putString(key_login_isLoggedIn, "true");
        return editor.commit();
    }

    public static boolean createSeassionNew(String userID, LoginDM loginData){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(loginData);
        editor.putString(key_login_data, json);
        editor.putString(key_login, userID);
        editor.putString(key_login_time,TimeUtils.getCurrentTime());
        editor.putString(key_login_isLoggedIn, "true");
        return editor.commit();
    }

    public static String getUserID(){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key_login, "None");    }

    public static boolean isLoggedIn(){
        boolean isL = false;
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String isLogin =  settings.getString(key_login_isLoggedIn, "false");

        if (isLogin.equals("true")) {
            isL = true;
        }else {
            isL = false;
        }

        return isL;
    }

    public static LoginData getSeassionData(){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = settings.getString(key_login_data, "");
        LoginData obj = gson.fromJson(json, LoginData.class);
        return obj;
    }

    public static LoginDM getSeassionDataNew(){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = settings.getString(key_login_data, "");
        LoginDM obj = gson.fromJson(json, LoginDM.class);
        return obj;
    }

    public static void clearSession(){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
        deleteCache(MyApplication.getContext());
    }

    public static boolean logout(){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key_login_isLoggedIn, "false");

        return editor.commit();
    }

    public static Long getSessionDuration(){
        TimeUtils timeUtils = new TimeUtils(getLoggedInTime());
        return timeUtils.getHours();
    }

    public static HashMap<String, String> getHeaders(){
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("SESSION_ID",getSeassionDataNew().getData().getSESSIONID());
        headers.put("SESSION_TOKEN", getSeassionDataNew().getData().getSESSIONTOKEN());

        return  headers;
    }

    //Private methods
    private static String getLoggedInTime(){
        SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key_login_time, "2019-05-05 12:50:50");
    }

    //============================  ##Session Data ##  ===========================//



    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

}
