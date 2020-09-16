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
import com.example.defenceline.adapters.CompanyAdapter;
import com.example.defenceline.model.Client;
import com.example.defenceline.model.Company;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CompanyDataActivity extends AppCompatActivity {

    CompanyAdapter mCompanyAdapter;
    private ArrayList<Company> mCompanies;
    private ImageView back, search;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_data);

        mRecyclerView = findViewById(R.id.company_rv);
        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        mCompanies = new ArrayList<>();
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mCompanyAdapter = new CompanyAdapter(mCompanies);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mCompanyAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CompanyDataActivity.this, MainActivity.class));
                finish();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // search code here
            }
        });
    }

    private void getData() {

        Query query =  FirebaseDatabase.getInstance().getReference().child("Companies");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mCompanies.clear();
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Company company = dataSnapshot.getValue(Company.class);
                        mCompanies.add(company);
                    }

                    mCompanyAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(CompanyDataActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}