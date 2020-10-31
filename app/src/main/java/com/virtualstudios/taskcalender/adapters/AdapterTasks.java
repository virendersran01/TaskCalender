package com.virtualstudios.taskcalender.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.virtualstudios.taskcalender.databinding.ItemContainerTasksListBinding;

import java.util.List;

public class AdapterTasks extends RecyclerView.Adapter<AdapterTasks.ViewHolder> {

    private List<String> tasks;

    public AdapterTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemContainerTasksListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
    private ItemContainerTasksListBinding itemContainerTasksListBinding;

        public ViewHolder(ItemContainerTasksListBinding itemContainerTasksListBinding) {
            super(itemContainerTasksListBinding.getRoot());
           this.itemContainerTasksListBinding = itemContainerTasksListBinding;
        }

        void bindData(String name){
            itemContainerTasksListBinding.textName.setText(name);
        }
    }
}
