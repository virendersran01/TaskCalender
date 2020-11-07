package com.virtualstudios.taskcalender.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.virtualstudios.taskcalender.utilities.DateConverter;

import java.util.Date;

@Entity(tableName = "task", foreignKeys = @ForeignKey(entity = TaskList.class,
        parentColumns = "enc_id",
        childColumns = "list_enc_id",
        onUpdate = ForeignKey.RESTRICT))
public class Task {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "enc_id")
    private String encId;

    @ColumnInfo(name = "list_enc_id")
    private String listEncId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "is_repeated")
    private int isRepeated; // 0 for No, 1 for Yes

    @ColumnInfo(name = "alert_date", defaultValue = "CURRENT_DATE")
    @TypeConverters(DateConverter.class)
    private Date alertDate;

    @ColumnInfo(name = "alert_time", defaultValue = "CURRENT_TIME")
    @TypeConverters(DateConverter.class)
    private Date alertTime;

    @ColumnInfo(name = "alert_before")
    private int alertBefore; // minutes

    @ColumnInfo(name = "repeat_on_every")
    private String repeatOnEvery; // enum Day, Week, Month, Year

    @ColumnInfo(name = "repeat_after")
    private int repeatAfter; // Repeat after x number of repeat_on_every value

    @ColumnInfo(name = "repeat_days")
    private String repeatDays; // repeat days of every week as json format ["1", "2", "7"]

    @ColumnInfo(name = "on_day")
    private String onDay;

    @ColumnInfo(name = "on_week")
    private String onWeek; // enum = First, Second, Third, Fourth, Last

    @ColumnInfo(name = "on_week_day")
    private String onWeekDay; // enum = Mon, Tue, Wed, Thu, Fri, Sat

    @ColumnInfo(name = "created_on", defaultValue = "CURRENT_TIMESTAMP")
    @TypeConverters(DateConverter.class)
    private Date createdOn;

    @ColumnInfo(name = "created_by")
    private String createdBy;

    @ColumnInfo(name = "is_synchronized", defaultValue = "0") // 0 as not synced, 1 as synced
    private int isSynchronized;

    @ColumnInfo(name = "is_deleted", defaultValue = "0") // 0 as not deleted, 1 as deleted
    private int isDeleted;

}
