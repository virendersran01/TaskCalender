package com.virtualstudios.taskcalender.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import com.virtualstudios.taskcalender.R;
import com.virtualstudios.taskcalender.adapters.AdapterTasks;
import com.virtualstudios.taskcalender.databinding.ActivityMainBinding;
import com.virtualstudios.taskcalender.databinding.LayoutBottomSheetStartBinding;
import com.virtualstudios.taskcalender.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private Context context;
    private PreferenceManager preferenceManager;
    private List<String> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        context = MainActivity.this;
        preferenceManager = new PreferenceManager(context);
        tasks = new ArrayList<>();
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");
        tasks.add("Task 4");
        tasks.add("Task 5");
        tasks.add("Task 6");
        tasks.add("Task 7");
        tasks.add("Task 8");
        tasks.add("Task 9");
        tasks.add("Task 10");
        tasks.add("Task 11");
        tasks.add("Task 12");
        tasks.add("Task 13");
        tasks.add("Task 14");
        tasks.add("Task 15");
        tasks.add("Task 16");
        tasks.add("Task 17");
        tasks.add("Task 18");
        tasks.add("Task 19");
        tasks.add("Task 20");

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

    private void initBottomSheetStart() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        LayoutBottomSheetStartBinding binding = LayoutBottomSheetStartBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding.getRoot());
//        Picasso.get().load(preferenceManager.getProfilePicUrl()).into(binding.imageUser);
//        binding.textUserName.setText(preferenceManager.getUserFullName());
//        binding.textUserEmail.setText(preferenceManager.getUserEmail());
        binding.recyclerViewTasks.setAdapter(new AdapterTasks(tasks));
        bottomSheetDialog.show();

        BottomSheetBehavior bottomSheetBehavior = bottomSheetDialog.getBehavior();
        bottomSheetBehavior.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.d("TAG", "onStateChanged: "+newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d("TAG", "onSlide: "+slideOffset);
            }
        });
    }
}