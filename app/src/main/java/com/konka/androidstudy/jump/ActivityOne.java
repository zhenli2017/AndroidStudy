package com.konka.androidstudy.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.konka.androidstudy.R;

public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        System.out.println("ActivityOne onCreate");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityOne.this, ActivityTwo.class));

            }
        });

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ActivityOne.this, JumpService.class));
            }
        });
        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ActivityOne.this, JumpService.class));
            }
        });
        findViewById(R.id.button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(ActivityOne.this, JumpService.class), mServiceConnection, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.button_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mServiceConnection);
            }
        });
        int taskId = getTaskId();
        System.out.println("ActivityOne taskId = "+taskId);
    }

    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("onServiceDisconnected");
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ActivityOne onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ActivityOne onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ActivityOne onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ActivityOne onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ActivityOne onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("ActivityOne onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("ActivityOne onNewIntent");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("ActivityOne onSaveInstanceState = "+this);
    }
}