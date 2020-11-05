package com.virtualstudios.taskcalender.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.virtualstudios.taskcalender.utilities.DateConverter;

import java.util.Date;

@Entity(tableName = "task_list")
public class TaskList {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "enc_id")
    private String encId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "created_on", defaultValue = "CURRENT_TIMESTAMP")
    @TypeConverters(DateConverter.class)
    private Date createdOn;

    @ColumnInfo(name = "created_by")
    private String createdBy;

    @ColumnInfo(name = "is_synchronized", defaultValue = "0") // 0 as not synced, 1 as synced
    private int isSynchronized;

    @ColumnInfo(name = "is_deleted", defaultValue = "0") // 0 as not deleted, 1 as deleted
    private int isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEncId() {
        return encId;
    }

    public void setEncId(String encId) {
        this.encId = encId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getIsSynchronized() {
        return isSynchronized;
    }

    public void setIsSynchronized(int isSynchronized) {
        this.isSynchronized = isSynchronized;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
