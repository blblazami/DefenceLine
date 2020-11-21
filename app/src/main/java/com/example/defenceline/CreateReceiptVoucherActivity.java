package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.defenceline.model.Voucher;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateReceiptVoucherActivity extends AppCompatActivity {

    private TextView dateView, voucherNumberView, receiverName;
    private EditText name, sumOf, bankName, transferDate, providedService;
    private CheckBox cash, cheque, bankTransfer;
    private Button save;
    private int mVoucherCounter;

    // Progress Dialog
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_receipt_voucher);

        dateView = findViewById(R.id.datetextview);
        voucherNumberView = findViewById(R.id.voucher_number_view);
        receiverName = findViewById(R.id.receiver_name);
        name = findViewById(R.id.client_name);
        sumOf = findViewById(R.id.sum_of);
        bankName = findViewById(R.id.bank_name);
        transferDate = findViewById(R.id.transfer_date);
        providedService = findViewById(R.id.service_provided);
        save = findViewById(R.id.save_button);
        cash = findViewById(R.id.cash_chkbox);
        cheque = findViewById(R.id.cheque_chkbox);
        bankTransfer = findViewById(R.id.bank_transfer_chkbox);

        mProgressDialog = new ProgressDialog(this);

        // to generate voucher number
        FirebaseManager.getCounter(FirebaseKeys.VOUCHER_COUNTER, new FirebaseManager.OnCounterReceived() {
            @Override
            public void onReceived(int voucherCounter) {
                mVoucherCounter = voucherCounter;
                voucherNumberView.setText(String.valueOf(mVoucherCounter));
            }
        });

        // to show date on text view
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        dateView.setText(df.format(dateobj));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtDateView = dateView.getText().toString();
                String txtVoucherNumberView = voucherNumberView.getText().toString();
                String txtReceiverName = receiverName.getText().toString();
                String txtName = name.getText().toString();
                String txtSumOf = sumOf.getText().toString();
                String txtBankName = bankName.getText().toString();
                String txtTransferDate = transferDate.getText().toString();
                String txtProvidedService = providedService.getText().toString();
                String paymentMethod = paymentChecked();

                if (TextUtils.isEmpty(txtDateView) || TextUtils.isEmpty(txtVoucherNumberView)
                || TextUtils.isEmpty(txtReceiverName) || TextUtils.isEmpty(txtName)
                || TextUtils.isEmpty(txtSumOf) || TextUtils.isEmpty(txtProvidedService) || paymentMethod == null){
                    Toast.makeText(CreateReceiptVoucherActivity.this, "Mandatory Missed", Toast.LENGTH_SHORT).show();
                } else {
                    createReceiptVoucher(txtDateView, txtVoucherNumberView, txtReceiverName, txtName, txtSumOf
                    , txtBankName, txtTransferDate, txtProvidedService, paymentMethod);
                }

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseManager.stopInvoiceCounterListener();
    }

    private void createReceiptVoucher(String dateView, String voucherNumberView, String receiverName, String name, String sumOf,
                                      String bankName, String transferDate, String providedService, String paymentMethod) {

        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.show();
        String id = FirebaseDatabase.getInstance().getReference().push().getKey();
        Voucher voucher = new Voucher(dateView, voucherNumberView, receiverName, name, sumOf
        , bankName, transferDate, providedService, paymentMethod);
        FirebaseDatabase.getInstance().getReference("Vouchers").child(id).setValue(voucher).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mProgressDialog.dismiss();
            }
        });
    }

    // checking payment method
    public String paymentChecked(){
        String payment = null;
        if (cash.isChecked()){
            payment = "Cash";
        } else if (cheque.isChecked()) {
            payment = "Cheque";
        } else if (bankTransfer.isChecked()) {
            payment = "Bank Transfer";
        } else {
            payment = null;
        }
        return payment;
    }

}