package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ClientDataActivity extends AppCompatActivity {

    private ImageView back, search;
    private Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_data);

        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        more = findViewById(R.id.more_button_id);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}