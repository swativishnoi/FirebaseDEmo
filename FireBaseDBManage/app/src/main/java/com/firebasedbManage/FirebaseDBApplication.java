package com.firebasedbManage;

import android.app.Application;
import android.content.Context;

import com.google.firebase.FirebaseApp;

public class FirebaseDBApplication extends Application {
    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(getApplicationContext());
    }
}
