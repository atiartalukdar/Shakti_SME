package bp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.evernote.android.job.JobManager;
import com.github.javiersantos.appupdater.AppUpdater;
import com.onesignal.OneSignal;
import com.sfdw.shaktisme.BuildConfig;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;
import locationprovider.davidserrano.com.LocationProvider;
import objectBox.ObjectBox;

public class MyApplication extends Application {
    private static Context context;
    private final String tag = MyApplication.class.getSimpleName() + "Atiar= ";
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ObjectBox.init(this);

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();


        if (BuildConfig.DEBUG) {
            boolean started = new AndroidObjectBrowser(ObjectBox.get()).start(this);
            Log.i("Atiar - ObjectBrowser", "Started: " + started);
        }


    }

    public static Context getContext (){return context; }
}
