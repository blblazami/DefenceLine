package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.defenceline.model.Client;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ContractServiceActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText name, phoneNo, location, price;
    private Button date, time, save;
    private CheckBox liquid, powder, gel;

    private int mHour, mMinutes;

    // Progress Dialog
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_service);

        name = findViewById(R.id.client_name);
        phoneNo = findViewById(R.id.client_phone);
        location = findViewById(R.id.client_location);
        price = findViewById(R.id.enter_price);
        date = findViewById(R.id.chose_date_btn_id);
        time = findViewById(R.id.chose_time_btn_id);
        save = findViewById(R.id.save_button);
        liquid = findViewById(R.id.liquid_chkbox);
        powder = findViewById(R.id.powder_chkbox);
        gel = findViewById(R.id.gel_chkbox);

        mProgressDialog = new ProgressDialog(this);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinutes = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(ContractServiceActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(ContractServiceActivity.this, "" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, mHour, mMinutes, false);
                timePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtName = name.getText().toString();
                String txtPhoneNo = phoneNo.getText().toString();
                String txtLocation = location.getText().toString();
                String txtPrice = price.getText().toString();

                if (TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtPhoneNo)
                        || TextUtils.isEmpty(txtLocation) || TextUtils.isEmpty(txtPrice)) {
                    Toast.makeText(ContractServiceActivity.this, "Mandatory Missed", Toast.LENGTH_SHORT).show();
                } else if (txtPhoneNo.length() < 10) {
                    Toast.makeText(ContractServiceActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    registerClient(txtName, txtPhoneNo, txtLocation, txtPrice);
                }
            }
        });
    }

    private void registerClient(String name, String phoneNo, String location, String price) {

        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.show();
        String id = FirebaseDatabase.getInstance().getReference().push().getKey();
        Client client = new Client(name, phoneNo, location, price);
        FirebaseDatabase.getInstance().getReference("Companies").child(id).setValue(client).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mProgressDialog.dismiss();
            }
        });
    }

    // showing date dialog
    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    // setting up date method
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month+=1;
        String datepick = "day/month/year: " + dayOfMonth + "/" + month + "/" + year;
        date.setText(datepick);
    }
}