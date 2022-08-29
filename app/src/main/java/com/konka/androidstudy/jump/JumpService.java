package com.konka.androidstudy.jump;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class JumpService extends Service {
    public JumpService() {
        System.out.println("JumpService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return new Binder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind");
        return super.onUnbind(intent);
    }

}