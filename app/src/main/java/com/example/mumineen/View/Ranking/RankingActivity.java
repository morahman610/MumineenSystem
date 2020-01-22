package com.example.mumineen.View.Ranking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.mumineen.R;

public class RankingActivity extends AppCompatActivity {

    private Button addPlayerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        setupUI();
    }

    private void setupUI() {
        addPlayerBtn = findViewById(R.id.addPlayerBtn);
    }
}
