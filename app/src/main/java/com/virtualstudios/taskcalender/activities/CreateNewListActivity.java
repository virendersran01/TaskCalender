package com.virtualstudios.taskcalender.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.virtualstudios.taskcalender.databinding.ActivityCreateNewListBinding;

public class CreateNewListActivity extends AppCompatActivity {

    private ActivityCreateNewListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateNewListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageClose.setOnClickListener(v -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });

        binding.textDone.setOnClickListener(v -> {
            setResult(Activity.RESULT_OK);
            finish();
        });
    }
}