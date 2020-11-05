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

import com.example.defenceline.adapters.VisitAdapter;
import com.example.defenceline.adapters.VoucherAdapter;
import com.example.defenceline.model.Visit;
import com.example.defenceline.model.Voucher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowVoucherActivity extends AppCompatActivity {

    private ImageView back, search;
    RecyclerView mRecyclerView;
    VoucherAdapter mVoucherAdapter;
    private ArrayList<Voucher> mVouchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_voucher);

        back = findViewById(R.id.back);
        search = findViewById(R.id.search);
        mRecyclerView = findViewById(R.id.voucher_rv);
        mVouchers = new ArrayList<>();
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mVoucherAdapter = new VoucherAdapter(mVouchers);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mVoucherAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowVoucherActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void getData() {

        Query query =  FirebaseDatabase.getInstance().getReference().child("Vouchers");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mVouchers.clear();
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Voucher voucher = dataSnapshot.getValue(Voucher.class);
                        mVouchers.add(voucher);
                    }

                    mVoucherAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(ShowVoucherActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}