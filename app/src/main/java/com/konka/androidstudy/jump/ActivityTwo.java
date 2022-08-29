package com.konka.androidstudy.jump;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.konka.androidstudy.R;

public class ActivityTwo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        System.out.println("ActivityTwo onCreate");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityTwo.this, ActivityOne.class));
            }
        });
        int taskId = getTaskId();
        System.out.println("ActivityTwo taskId = "+taskId);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ActivityTwo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ActivityTwo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ActivityTwo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ActivityTwo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ActivityTwo onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("ActivityTwo onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("ActivityTwo onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}