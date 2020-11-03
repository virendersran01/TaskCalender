package com.virtualstudios.taskcalender.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import com.virtualstudios.taskcalender.R;
import com.virtualstudios.taskcalender.adapters.AdapterTasks;
import com.virtualstudios.taskcalender.databinding.ActivityMainBinding;
import com.virtualstudios.taskcalender.databinding.LayoutBottomSheetAddTaskBinding;
import com.virtualstudios.taskcalender.databinding.LayoutBottomSheetEndBinding;
import com.virtualstudios.taskcalender.databinding.LayoutBottomSheetStartBinding;
import com.virtualstudios.taskcalender.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private Context context;
    private PreferenceManager preferenceManager;
    private List<String> tasks;
    private BottomSheetDialog bottomSheetDialogStart, bottomSheetDialogEnd, bottomSheetNewTask;
    private final int REQUEST_CODE_CREATE_NEW_LIST = 0;

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

        initNewTaskBottomSheet();
        initBottomSheetStart();
        initBottomSheetEnd();

        activityMainBinding.bottomAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.itemOptions){
                bottomSheetDialogEnd.show();
            }
            return false;
        });

        activityMainBinding.bottomAppBar.setNavigationOnClickListener(v -> bottomSheetDialogStart.show());

        activityMainBinding.fabNewTask.setOnClickListener(v -> bottomSheetNewTask.show());

    }

    private void initBottomSheetStart() {
        bottomSheetDialogStart = new BottomSheetDialog(context);
        LayoutBottomSheetStartBinding binding = LayoutBottomSheetStartBinding.inflate(getLayoutInflater());
        bottomSheetDialogStart.setContentView(binding.getRoot());
        Picasso.get().load(preferenceManager.getProfilePicUrl()).into(binding.imageUser);
        binding.textUserName.setText(preferenceManager.getUserFullName());
        binding.textUserEmail.setText(preferenceManager.getUserEmail());
        binding.imageUser.setImageResource(R.drawable.ic_google_logo);
        binding.textUserName.setText("Android");
        binding.textUserEmail.setText("android@google.com");
        binding.recyclerViewTasks.setAdapter(new AdapterTasks(tasks));
        binding.imageClose.setOnClickListener(v -> bottomSheetDialogStart.dismiss());
        binding.textCreateNewList.setOnClickListener(v -> {
            bottomSheetDialogStart.dismiss();
            Intent intent = new Intent(getApplicationContext(), CreateNewListActivity.class);
            startActivityForResult(intent, REQUEST_CODE_CREATE_NEW_LIST);
        });

        FrameLayout frameLayout = bottomSheetDialogStart.findViewById(
                com.google.android.material.R.id.design_bottom_sheet
        );
        if (frameLayout != null){
            BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(frameLayout);
            bottomSheetBehavior.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }

    }

    private void initBottomSheetEnd() {
        bottomSheetDialogEnd = new BottomSheetDialog(context);
        LayoutBottomSheetEndBinding binding = LayoutBottomSheetEndBinding.inflate(getLayoutInflater());
        bottomSheetDialogEnd.setContentView(binding.getRoot());

    }

    private void initNewTaskBottomSheet(){
        bottomSheetNewTask = new BottomSheetDialog(context, R.style.DialogStyle);
        LayoutBottomSheetAddTaskBinding binding = LayoutBottomSheetAddTaskBinding.inflate(getLayoutInflater());
        bottomSheetNewTask.setContentView(binding.getRoot());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREATE_NEW_LIST){
            switch (resultCode){
                case RESULT_OK:
                    Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }
}