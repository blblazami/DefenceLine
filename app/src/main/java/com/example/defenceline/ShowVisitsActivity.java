package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

public class ShowVisitsActivity extends AppCompatActivity {

    private ImageView back, search;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_visits);

        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        mRecyclerView = findViewById(R.id.visit_rv);

    }
}