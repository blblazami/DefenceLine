package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InvoiceActivity extends AppCompatActivity {

    TextView clientInvoiceShow, companyInvoiceShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        clientInvoiceShow = findViewById(R.id.show_client_invoice);
        companyInvoiceShow = findViewById(R.id.show_company_invoice);

        clientInvoiceShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        companyInvoiceShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}