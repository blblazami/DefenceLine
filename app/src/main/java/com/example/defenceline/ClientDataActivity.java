package com.example.defenceline;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.defenceline.adapters.ClientAdapter;
import com.example.defenceline.model.Client;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ClientDataActivity extends AppCompatActivity {

    final int REQ_CODE_MORE = 1;
    ClientAdapter mClientAdapter;
    private ArrayList<Client> mClients;
    ImageView back, search;

    private RecyclerView mRecyclerView;
    private Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_data);

        mRecyclerView = findViewById(R.id.client_rv);
        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        mClients = new ArrayList<>();
        getData();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mClientAdapter = new ClientAdapter(mClients);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mClientAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClientDataActivity.this, MainActivity.class));
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

        Query query =  FirebaseDatabase.getInstance().getReference().child("Clients");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mClients.clear();
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Client client = dataSnapshot.getValue(Client.class);
                        mClients.add(client);
                    }

                    mClientAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(ClientDataActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == REQ_CODE_MORE && resultCode == RESULT_OK){
//            mClientAdapter.addItem();
//        }
    }