package com.vijayjaidewan01vivekrai.aussies;

import android.app.Application;
import android.content.Context;

/**
 * Created by MR VIVEK RAI on 06-06-2018.
 */
public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}