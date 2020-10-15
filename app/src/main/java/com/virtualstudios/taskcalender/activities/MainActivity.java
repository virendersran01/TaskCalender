package com.virtualstudios.taskcalender.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import com.virtualstudios.taskcalender.R;
import com.virtualstudios.taskcalender.databinding.ActivityMainBinding;
import com.virtualstudios.taskcalender.databinding.LayoutBottomSheetStartBinding;
import com.virtualstudios.taskcalender.utilities.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private Context context;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        context = MainActivity.this;
        preferenceManager = new PreferenceManager(context);

        activityMainBinding.bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        activityMainBinding.bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBottomSheetStart();
            }
        });
    }

    private void initBottomSheetStart(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        LayoutBottomSheetStartBinding binding = LayoutBottomSheetStartBinding.inflate(getLayoutInflater());
//        View view = LayoutInflater.from(context).inflate(R.layout.layout_bottom_sheet_start, null);
        bottomSheetDialog.setContentView(binding.getRoot());
        Picasso.get().load(preferenceManager.getProfilePicUrl()).into(binding.imageUser);
        binding.textUserName.setText(preferenceManager.getUserFullName());
        binding.textUserEmail.setText(preferenceManager.getUserEmail());
        bottomSheetDialog.show();
    }
}