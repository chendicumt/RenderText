package com.chendi.rendertext.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by PC on 2017/11/8.
 */

public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        context=getApplicationContext();
    }

    public static Context getContext()
    {
        return context;
    }
}
