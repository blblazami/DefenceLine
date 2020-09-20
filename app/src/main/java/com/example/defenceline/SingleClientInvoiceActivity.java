package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class SingleClientInvoiceActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView dateView, orderNumber, accountantName;
    private EditText name, itemNumber, description, quantity, price, total, discount;
    private Button addInvoice;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_client_invoice);

        mToolbar = findViewById(R.id.toolbar);
        dateView = findViewById(R.id.datetextview);
        orderNumber = findViewById(R.id.order_number_view);
        accountantName = findViewById(R.id.accountant_name);
        name = findViewById(R.id.name);
        itemNumber = findViewById(R.id.item_no);
        description = findViewById(R.id.description);
        quantity = findViewById(R.id.quantity);
        price = findViewById(R.id.price);
        total = findViewById(R.id.total);
        discount = findViewById(R.id.discount);
        addInvoice = findViewById(R.id.create_invoice);
        mProgressDialog = new ProgressDialog(this);

    }
}