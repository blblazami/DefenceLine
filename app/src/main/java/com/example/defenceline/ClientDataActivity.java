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

import com.example.defenceline.adapters.ClientAdapter;
import com.example.defenceline.model.Client;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ClientDataActivity extends AppCompatActivity {

    final int REQ_CODE_MORE = 1;
    ClientAdapter mClientAdapter;

    private List<Client> mClients;
    private RecyclerView mRecyclerView;
    private Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_data);

        more = findViewById(R.id.more_button);
        mRecyclerView = findViewById(R.id.client_rv);

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Belal", "0555607665", "www.google.com", "250"));
        clients.add(new Client("Belal", "0555607665", "www.google.com", "250"));
        clients.add(new Client("Belal", "0555607665", "www.google.com", "250"));

        ClientAdapter adapter = new ClientAdapter(clients);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), this.getClass());
                startActivityForResult(intent, REQ_CODE_MORE);

                getData();
            }
        });
    }

    private void getData() {
        String id = FirebaseDatabase.getInstance().getReference().getKey();
        FirebaseDatabase.getInstance().getReference().child("Clients").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mClients.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Client client =dataSnapshot.getValue(Client.class);
                    mClients.add(client);
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