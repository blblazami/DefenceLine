package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.defenceline.model.Invoice;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateInvoiceActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView dateView;
    private TextView invoiceNumber;
    private TextView accountantName;
    private EditText name, itemNumber, description, quantity, price, total, discount;
    private Button addInvoice;
    private ProgressDialog mProgressDialog;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_invoice);

        toolbar = findViewById(R.id.toolbar);
        dateView = findViewById(R.id.datetextview);
        invoiceNumber = findViewById(R.id.invoice_number_view);
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

        // to generate invoice number
        mPreferences = getSharedPreferences("OsDB", MODE_PRIVATE);
        invoiceNumber.setText(mPreferences.getString("OsId", "10001"));
        // to show date on text view
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        dateView.setText(df.format(dateobj));

        addInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtDate = dateView.getText().toString();
                String txtInvoiceNumber = invoiceNumber.getText().toString();
                String txtName = name.getText().toString();
                String txtItemNumber = itemNumber.getText().toString();
                String txtDescription = description.getText().toString();
                String txtQuantity = quantity.getText().toString();
                String txtAccountant = accountantName.getText().toString();
                String txtPrice = price.getText().toString();
                String txtTotal = total.getText().toString();
                String txtDiscount = discount.getText().toString();

                if (TextUtils.isEmpty(txtDate) || TextUtils.isEmpty(txtInvoiceNumber)
                        || TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtItemNumber)
                        || TextUtils.isEmpty(txtDescription) || TextUtils.isEmpty(txtQuantity)
                        || TextUtils.isEmpty(txtAccountant) || TextUtils.isEmpty(txtPrice)
                        || TextUtils.isEmpty(txtTotal) || TextUtils.isEmpty(txtDiscount)) {
                    Toast.makeText(CreateInvoiceActivity.this, "Mandatory Missed", Toast.LENGTH_SHORT).show();
                } else {
                    createInvoice(txtDate, txtInvoiceNumber, txtName, txtItemNumber, txtDescription, txtQuantity, txtAccountant, txtPrice, txtTotal, txtDiscount);
                }
            }
        });

    }

    private void createInvoice(String date, String invoiceNumber, String name, String itemNumber, String description,
                               String quantity, String accountant, String price, String total, String discount) {

        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.show();
        String id = FirebaseDatabase.getInstance().getReference().push().getKey();
        Invoice invoice = new Invoice(date, invoiceNumber, name, itemNumber, description, quantity, accountant, price, total, discount);
        FirebaseDatabase.getInstance().getReference("Invoice").child(id).setValue(invoice).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mProgressDialog.dismiss();

            }
        });
    }
}