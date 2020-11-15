package com.example.defenceline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.defenceline.adapters.InvoiceAdapter;
import com.example.defenceline.model.Invoice;
import com.example.defenceline.model.Voucher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class InvoiceActivity extends AppCompatActivity {

    ImageView back, search;
    RecyclerView mRecyclerView;
    InvoiceAdapter mInvoiceAdapter;
    private ArrayList<Invoice> mInvoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        mRecyclerView = findViewById(R.id.invoice_rv);
        mInvoices = new ArrayList<>();
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mInvoiceAdapter = new InvoiceAdapter(mInvoices);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mInvoiceAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvoiceActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void getData() {

        Query query =  FirebaseDatabase.getInstance().getReference().child("Invoices");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mInvoices.clear();
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Invoice invoice = dataSnapshot.getValue(Invoice.class);
                        mInvoices.add(invoice);
                    }

                    mInvoiceAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(InvoiceActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}