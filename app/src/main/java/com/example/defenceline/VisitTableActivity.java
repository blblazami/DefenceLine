package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VisitTableActivity extends AppCompatActivity {

    ImageView back, search;
    TextView createVisit, showVisits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_table);

        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        createVisit = findViewById(R.id.create_visit);
        showVisits = findViewById(R.id.show_visit);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code must added here
                startActivity(new Intent(VisitTableActivity.this, MainActivity.class));
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code must added here
            }
        });

        createVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VisitTableActivity.this, CreateVisitActivity.class));
            }
        });

        showVisits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VisitTableActivity.this, ShowVisitsActivity.class));
                finish();
            }
        });

    }
}