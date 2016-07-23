package com.rba.mvpproject.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ricardo Bravo on 23/07/16.
 */

public class MVPProjectApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        MVPProjectApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MVPProjectApplication.context;
    }
}
