package com.example.mumineen.View.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mumineen.R;

public class LeagueMainFragment extends Fragment {

    private Button rankingButton;
    private Button mainToEventsButton;
    View view;

    private NavController navController = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_league_main, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupUI();
    }

    private void setupUI() {

        navController = Navigation.findNavController(view);
        rankingButton = view.findViewById(R.id.rankingBtn);
        mainToEventsButton = view.findViewById(R.id.mainToEventsButton);

        rankingButton.setOnClickListener(v -> {
            navController.navigate(R.id.action_leagueMainFragment_to_rankingFragment);
        });
        mainToEventsButton.setOnClickListener(v -> {
            navController.navigate(R.id.action_leagueMainFragment_to_displayEventsFragment);
        });

    }
}