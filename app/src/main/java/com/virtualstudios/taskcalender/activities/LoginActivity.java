package com.virtualstudios.taskcalender.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.virtualstudios.taskcalender.R;
import com.virtualstudios.taskcalender.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonGoogle.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}