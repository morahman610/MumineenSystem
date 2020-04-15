package com.example.mumineen.View.Ranking;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mumineen.Adapter.EventsStatePagerAdapter;
import com.example.mumineen.Adapter.RankingsRecyclerViewAdapter;
import com.example.mumineen.Model.Player;
import com.example.mumineen.R;
import com.example.mumineen.View.Events.DisplayEventsFragment;
import com.example.mumineen.View.Events.EventPointsFragment;
import com.example.mumineen.View.Events.NewEventDialogFragment;
import com.example.mumineen.ViewModel.EventsViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment{

    private static final String TAG = "RankingFragment";

    EventsViewModel eventsViewModel;

    private View view;
    private Button addPlayerBtn;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    private NavController navController = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ranking, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        addPlayerBtn = view.findViewById(R.id.addPlayerBtn);
        addPlayerBtn.setOnClickListener(v -> navController.navigate(R.id.action_rankingFragment_to_addPlayerFragment));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        eventsViewModel = ViewModelProviders.of(getActivity()).get(EventsViewModel.class);

        Disposable disposable = eventsViewModel.getAllPlayers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( modelClass -> {

                    Log.d(TAG, "onActivityCreated RankingFragment");
                    if (modelClass.size() > 0) {
                        initRecyclerView((ArrayList<Player>) modelClass);
                        }
                    }, e -> e.getMessage()

                );

        compositeDisposable.add(disposable);

    }

    private void initRecyclerView(ArrayList<Player> allPlayersArrayList) {

        RecyclerView rankingRecyclerView = view.findViewById(R.id.rankingRecyclerView);
        RankingsRecyclerViewAdapter adapter = new RankingsRecyclerViewAdapter(getActivity(), allPlayersArrayList);
        rankingRecyclerView.setAdapter(adapter);
        rankingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
