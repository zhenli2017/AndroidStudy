package com.konka.androidstudy.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.konka.androidstudy.R;
import com.konka.androidstudy.jump.AAAViewModel;

public class SaveStateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state);

        new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(AAAViewModel.class);
    }
}