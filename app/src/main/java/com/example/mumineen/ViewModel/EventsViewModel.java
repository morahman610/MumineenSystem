package com.example.mumineen.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mumineen.Model.Event;
import com.example.mumineen.DB.MumineenRepository;

import java.util.List;

import io.reactivex.Observable;

public class EventsViewModel extends AndroidViewModel {

    private MumineenRepository mumineenRepository;
    private LiveData<List<Event>> allevents;

    public EventsViewModel(@NonNull Application application) {
        super(application);
        mumineenRepository = new MumineenRepository(application);
    }

    public void insert(Event event) { mumineenRepository.addEvent(event);}

    public Observable<List<Event>> getAllevents() {return mumineenRepository.getAllEvents();}
}
