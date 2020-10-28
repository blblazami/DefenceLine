package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

public class ShowVoucherActivity extends AppCompatActivity {

    private ImageView back, search;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_voucher);

        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        mRecyclerView = findViewById(R.id.voucher_rv);

    }
}