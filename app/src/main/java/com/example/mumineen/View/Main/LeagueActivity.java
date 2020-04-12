package com.example.mumineen.View.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mumineen.R;
import com.example.mumineen.View.Events.EventsActivity;
import com.example.mumineen.View.RankingActivity;

public class LeagueActivity extends AppCompatActivity {

    private Button rankingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        setupUI();
    }

    private void setupUI() {
        rankingButton = findViewById(R.id.rankingBtn);
        rankingButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), RankingActivity.class);
            startActivity(intent);
        });
    }

    public void activityIntentOnClick(View view) {
        Intent intent = new Intent(this, EventsActivity.class);
        startActivity(intent);
    }
}