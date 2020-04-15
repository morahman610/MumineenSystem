package com.example.mumineen.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mumineen.Model.Event;
import com.example.mumineen.DB.MumineenRepository;
import com.example.mumineen.Model.Player;

import java.util.List;

import io.reactivex.Observable;

public class EventsViewModel extends AndroidViewModel {

    private MumineenRepository mumineenRepository;
    private LiveData<List<Event>> allevents;

    public EventsViewModel(@NonNull Application application) {
        super(application);
        mumineenRepository = new MumineenRepository(application);
    }

    public void insertEvent(Event event) { mumineenRepository.addEvent(event);}
    public void insertPlayer(Player player) {mumineenRepository.addPlayer(player);}

    public Observable<List<Event>> getAllEvents() {return mumineenRepository.getAllEvents();}
    public Observable<List<Player>> getAllPlayers() {return mumineenRepository.getAllPlayers();}

    public void updatePlayer(Player player) { mumineenRepository.updatePlayer(player);}
}
