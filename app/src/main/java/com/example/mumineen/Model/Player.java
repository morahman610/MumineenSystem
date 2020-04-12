package com.example.mumineen.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player_table")
public class Player {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    @NonNull
    public int playerID;

    @ColumnInfo(name = "Name")
    @NonNull
    public String playerName;

    @ColumnInfo(name = "Team")
    @NonNull
    public String playerTeam;

    @ColumnInfo(name = "Total Points")
    public int totalPoints;

}
