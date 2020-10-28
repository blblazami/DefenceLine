package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceiptVoucherActivity extends AppCompatActivity {

    private ImageView back;
    private TextView createReceiptVoucher, showVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_voucher);

        back = findViewById(R.id.back);
        createReceiptVoucher = findViewById(R.id.create_receipt_voucher);
        showVoucher = findViewById(R.id.show_voucher);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReceiptVoucherActivity.this, MainActivity.class));
            }
        });

        createReceiptVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReceiptVoucherActivity.this, CreateReceiptVoucherActivity.class));
            }
        });

        showVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReceiptVoucherActivity.this, ShowVoucherActivity.class));
            }
        });

    }
}