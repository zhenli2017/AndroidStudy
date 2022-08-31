package com.konka.androidstudy.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class BinderService extends Service {
    public BinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return iBinder;
    }

    private final IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };
}