package com.dan.basemodule;

import android.app.Application;
import android.content.Context;

public class ModuleApplication extends Application {

    private static ModuleApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    public static ModuleApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
