package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.defenceline.model.Invoice;

import java.util.ArrayList;

public class InvoiceActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ArrayList<Invoice> invoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        mToolbar = findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.rv_invoice);
    }
}