package xyz.pozhu.demo;

import android.app.Application;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PzLog.setLevel(PzLog.VERBOSE);
    }
}
