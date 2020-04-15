package com.example.mumineen.View.Events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mumineen.R;

public class EventPointsFragment extends Fragment {

    private static final String TAG = "EventPointsFragment";

    private TextView eventNameTxt;
    private RecyclerView eventPointsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_points, container, false);
        eventNameTxt = view.findViewById(R.id.eventNameTxt);
        eventPointsRecyclerView = view.findViewById(R.id.eventPointsRecyclerVew);

        return view;
    }
}
