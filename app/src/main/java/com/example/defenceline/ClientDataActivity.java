package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.defenceline.adapters.ClientAdapter;
import com.example.defenceline.model.Client;

import java.util.ArrayList;

public class ClientDataActivity extends AppCompatActivity {

    private ListView clientList;
    private Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_data);

        more = findViewById(R.id.more_button);
        clientList = findViewById(R.id.client_list);

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Belal", "0555607665", "www.google.com", "250"));
        clients.add(new Client("Belal", "0555607665", "www.google.com", "250"));
        clients.add(new Client("Belal", "0555607665", "www.google.com", "250"));

        ClientAdapter adapter = new ClientAdapter(this, R.layout.custom_client_data_show,clients);
        clientList.setAdapter(adapter);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}