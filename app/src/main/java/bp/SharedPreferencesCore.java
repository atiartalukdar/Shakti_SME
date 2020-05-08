package bp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SharedPreferencesCore {
    private String PREFERENCE_NAME;
    Gson gson = new Gson();

    public SharedPreferencesCore(String PREFERENCE_NAME) {
        this.PREFERENCE_NAME = PREFERENCE_NAME;
    }

    public boolean setPreference(String key, String value) {
        android.content.SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public String getPreference(String key) {
        android.content.SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, "None");
    }

    public <T> List<T> getList(String key, Class<T> classNames) {
        android.content.SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        Type typeOfT = TypeToken.getParameterized(List.class, classNames).getType();
        return gson.fromJson(settings.getString(key, null), typeOfT);
    }

    public void clear(){
        android.content.SharedPreferences settings = MyApplication.getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }

}
