package com.example.mumineen.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.mumineen.Adapter.EventsStatePagerAdapter;
import com.example.mumineen.R;
import com.example.mumineen.View.Events.DisplayEventsFragment;
import com.example.mumineen.View.Events.EventPointsFragment;
import com.example.mumineen.View.Events.NewEventDialogFragment;
import com.example.mumineen.View.Ranking.AddPlayerFragment;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class RankingActivity extends AppCompatActivity {

    private static final String TAG = "RankingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

    }
}
