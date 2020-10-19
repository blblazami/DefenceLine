package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLinearLayout;
    private TextView singleService, contractService, invoice, visitTable, receiptVoucher, clientsData, companiesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLinearLayout = findViewById(R.id.main_LL);
        singleService = findViewById(R.id.single_service_id);
        contractService = findViewById(R.id.contract_service);
        invoice = findViewById(R.id.invoice_id);
        visitTable = findViewById(R.id.visit_table);
        receiptVoucher = findViewById(R.id.receipt_voucher);
        clientsData = findViewById(R.id.clients_data);
        companiesData = findViewById(R.id.companies_data);

        singleService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleServiceActivity.class));
            }
        });

        contractService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContractServiceActivity.class));
            }
        });

        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InvoiceActivity.class));
            }
        });

        visitTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VisitTableActivity.class));
            }
        });

        receiptVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ReceiptVoucherActivity.class));
            }
        });

        clientsData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClientDataActivity.class));
            }
        });

        companiesData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CompanyDataActivity.class));
            }
        });
    }
}