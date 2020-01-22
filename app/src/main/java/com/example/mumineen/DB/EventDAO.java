package com.example.mumineen.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mumineen.Model.Event;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface EventDAO {

    @Insert
    void insert(Event event);

    @Update
    void update(Event event);

    @Delete
    void delete(Event event);

    @Query("SELECT * FROM event_table" )
    Observable<List<Event>> getAllEvents();
}