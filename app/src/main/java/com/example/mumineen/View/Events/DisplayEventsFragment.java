package com.example.mumineen.View.Events;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mumineen.Adapter.EventsRecyclerViewAdapter;
import com.example.mumineen.Model.Event;
import com.example.mumineen.R;
import com.example.mumineen.ViewModel.EventsViewModel;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class DisplayEventsFragment extends Fragment {

    //ViewModel
    EventsViewModel eventsViewModel;

    //Views
    View view;
    private Button addEventDialogBtn;

    //CompositeDisposable
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_events, container, false);

        eventsViewModel = ViewModelProviders.of(this).get(EventsViewModel.class);

        initCreateEventButton();

        getAllEvents();

        return view;
    }

    private void initCreateEventButton() {
        addEventDialogBtn = view.findViewById(R.id.addEventBtn);

        addEventDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((EventsActivity)getActivity()).setViewPager(2);
             //   NewEventDialogFragment dialog = new NewEventDialogFragment();
             //   dialog.show(getSupportFragmentManager(), "NewEventDialogFragment");
            }
        });
    }

    private void getAllEvents() {
        Disposable disposable =  eventsViewModel.getAllEvents().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(modelClass -> {
                    Log.d(TAG, "++SUBSCRIBED++");

                    if(modelClass.size() > 0) {
                        initRecyclerView((ArrayList<Event>) modelClass);
                    }
                }, e -> e.getMessage());

        compositeDisposable.add(disposable);
    }

    private void initRecyclerView(ArrayList<Event> eventArrayList) {
        RecyclerView eventsRecyclerView = view.findViewById(R.id.eventsRecyclerView);
        EventsRecyclerViewAdapter eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter(getActivity(), eventArrayList);
        eventsRecyclerView.setAdapter(eventsRecyclerViewAdapter);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
