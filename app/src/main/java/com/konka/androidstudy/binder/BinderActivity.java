package com.konka.androidstudy.binder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.konka.androidstudy.R;

public class BinderActivity extends AppCompatActivity implements ServiceConnection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder);
        bindService(new Intent(this,BinderService.class),this,BIND_AUTO_CREATE);

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
IMyAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    @Override
    public void onBindingDied(ComponentName name) {
        ServiceConnection.super.onBindingDied(name);
    }

    @Override
    public void onNullBinding(ComponentName name) {
        ServiceConnection.super.onNullBinding(name);
    }
}