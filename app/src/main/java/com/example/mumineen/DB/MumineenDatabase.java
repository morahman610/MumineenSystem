package com.example.mumineen.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mumineen.Model.Event;
import com.example.mumineen.Model.Player;


//CHANGE NEEDED: DATABASE IS BEING ACCESSED ON THE MAIN THREAD
@Database(entities = {Player.class, Event.class}, version = 3, exportSchema = false)
@TypeConverters({Converters.class})
abstract class MumineenDatabase extends RoomDatabase {

    private static MumineenDatabase instance;

    public abstract PlayerDAO playerDAO();
    public abstract EventDAO eventDAO();

    public static synchronized MumineenDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    MumineenDatabase.class,
                    "mumineen_database"
            ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries() //CHANGE NEEDED: use RxJava to prevent calls from main thread
                    .build();
        }
        return instance;
    }
}
