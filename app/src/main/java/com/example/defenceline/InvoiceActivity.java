package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InvoiceActivity extends AppCompatActivity {

    TextView createInvoice, clientInvoiceShow, companyInvoiceShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        createInvoice = findViewById(R.id.create_invoice);
        clientInvoiceShow = findViewById(R.id.show_client_invoice);
        companyInvoiceShow = findViewById(R.id.show_company_invoice);

        createInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvoiceActivity.this, CreateInvoiceActivity.class));
            }
        });

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