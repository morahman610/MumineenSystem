package com.example.mumineen.DB;

import android.app.Application;
import android.util.Log;

import com.example.mumineen.Model.Event;
import com.example.mumineen.Model.Player;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MumineenRepository {

    private static final String TAG = "MumineenRepository";

    private static MumineenRepository instance;

    private PlayerDAO playerDAO;
    private EventDAO eventDAO;
    private Observable<List<Player>> allplayers;
    private Observable<List<Event>> allEvents;


    public MumineenRepository(Application application){

        MumineenDatabase mumineenDatabase = MumineenDatabase.getInstance(application);

        playerDAO = mumineenDatabase.playerDAO();
        eventDAO = mumineenDatabase.eventDAO();

        allplayers = playerDAO.getAllPlayers();
        allEvents =  eventDAO.getAllEvents();
    }

    public Observable<List<Event>> getAllEvents() {
        return allEvents;
    }

    public void addEvent(Event event) {
        Completable.fromAction(() -> eventDAO.insert(event)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: Called");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onSubscribe: Event Insertion Successful");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                    }
                });
    }
}
