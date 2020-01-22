package com.example.mumineen.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "event_table")
public class Event {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    @NonNull
    public int eventID;

    @ColumnInfo(name = "Name")
    @NonNull
    public String eventName;

    @ColumnInfo(name = "Day")
   // @NonNull
    public Date eventDay;

    @ColumnInfo(name = "Points Available")
    @NonNull
    public int pointsAvailable;
}
