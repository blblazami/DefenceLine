package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.defenceline.model.Invoice;

import java.util.ArrayList;

public class InvoiceActivity extends AppCompatActivity {

    TextView singleInvoice, contractInvoice, clientInvoiceShow, companyInvoiceShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        singleInvoice = findViewById(R.id.create_single_service_invoice);
        contractInvoice = findViewById(R.id.create_contract_service_invoice);
        clientInvoiceShow = findViewById(R.id.show_client_invoice);
        companyInvoiceShow = findViewById(R.id.show_company_invoice);

        singleInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvoiceActivity.this, SingleClientInvoiceActivity.class));
            }
        });

        contractInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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