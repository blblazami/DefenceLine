package com.example.defenceline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.defenceline.adapters.ClientAdapter;
import com.example.defenceline.adapters.VisitAdapter;
import com.example.defenceline.model.Client;
import com.example.defenceline.model.Visit;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowVisitsActivity extends AppCompatActivity {

    private ImageView back, search;
    private RecyclerView mRecyclerView;
    VisitAdapter mVisitAdapter;
    private ArrayList<Visit> mVisits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_visits);

        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        mRecyclerView = findViewById(R.id.visit_rv);
        mVisits = new ArrayList<>();
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mVisitAdapter = new VisitAdapter(mVisits);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mVisitAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowVisitsActivity.this, MainActivity.class));
                finish();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code must be here
            }
        });

    }

    private void getData() {

        Query query =  FirebaseDatabase.getInstance().getReference().child("Visits");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mVisits.clear();
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Visit visit = dataSnapshot.getValue(Visit.class);
                        mVisits.add(visit);
                    }

                    mVisitAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(ShowVisitsActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}