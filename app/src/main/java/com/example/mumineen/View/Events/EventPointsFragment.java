package com.example.mumineen.View.Events;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mumineen.Adapter.EventPointsRecyclerViewAdapter;
import com.example.mumineen.Model.Player;
import com.example.mumineen.R;
import com.example.mumineen.ViewModel.EventsViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EventPointsFragment extends Fragment {

    private static final String TAG = "EventPointsFragment";

    private TextView eventNameTxt;
    private RecyclerView eventPointsRecyclerView;
    private View view;
    private List<Player> allPlayers;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    EventsViewModel eventsViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event_points, container, false);

        initUI(view);

        getAllEvents();


        return view;
    }

    private void initUI(View view) {
        eventNameTxt = view.findViewById(R.id.eventNameTxt);
        eventPointsRecyclerView = view.findViewById(R.id.eventsRecyclerView);
    }

    private void getAllEvents() {

        eventsViewModel = ViewModelProviders.of(this).get(EventsViewModel.class);
        Disposable disposable =  eventsViewModel.getAllPlayers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(players -> {
                    Log.d(TAG, "++SUBSCRIBED++");

                    if(players.size() > 0) {
                        initRecyclerView((ArrayList<Player>) players);
                        allPlayers = players;
                    }
                }, e -> e.getMessage());

        compositeDisposable.add(disposable);
    }

    public void initRecyclerView(ArrayList<Player> players) {
        RecyclerView recyclerView = view.findViewById(R.id.eventPointsRecyclerVew);
        EventPointsRecyclerViewAdapter eventPointsRecyclerViewAdapter = new EventPointsRecyclerViewAdapter(getActivity(), players);
        recyclerView.setAdapter(eventPointsRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        eventPointsRecyclerViewAdapter.setOnItemClickListener(new EventPointsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnAddPointClick(int position) {

                eventsViewModel.updatePlayer(allPlayers.get(position));
            }
        });

    }
}
