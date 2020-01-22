package com.example.mumineen.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mumineen.Model.Player;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface PlayerDAO {

    @Insert
    void insert(Player player);

    @Update
    void update(Player player);

    @Delete
    void delete(Player player);

    @Query("SELECT * FROM player_table" )
    Observable<List<Player>> getAllPlayers();
}
