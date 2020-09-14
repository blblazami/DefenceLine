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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.defenceline.model.Client;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SingleServiceActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText name, phoneNo, location, price;
    private Button date, time, save;
    private CheckBox liquid, powder, gel;
    private TextView dateView, timeView;

    private int mHour, mMinutes;

    // FB user should Declared here!!
    private DatabaseReference mRootReference;

    // Progress Dialog
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_service);

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
        dateView = findViewById(R.id.date_view);
        timeView = findViewById(R.id.time_view);

        mRootReference = FirebaseDatabase.getInstance().getReference();
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

                TimePickerDialog timePickerDialog = new TimePickerDialog(SingleServiceActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeView.setText(hourOfDay + ":" + minute);
                    }
                },mHour,mMinutes,false);
                timePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtName = name.getText().toString();
                String txtPhoneNo = phoneNo.getText().toString();
                String txtLocation = location.getText().toString();
                String txtDate = dateView.getText().toString();
                String txtTime = timeView.getText().toString();
                String serviceType = serviceChecked();
                String txtPrice = price.getText().toString();


                if (TextUtils.isEmpty(txtName) || TextUtils.isEmpty((txtPhoneNo))
                || TextUtils.isEmpty(txtLocation) || TextUtils.isEmpty(txtPrice)
                || TextUtils.isEmpty(txtDate) || TextUtils.isEmpty(txtTime)
                || serviceType == null){
                    Toast.makeText(SingleServiceActivity.this, "Mandatory Missed", Toast.LENGTH_SHORT).show();
                } else if (txtPhoneNo.length() < 10){
                    Toast.makeText(SingleServiceActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    registerClient(txtName, txtPhoneNo, txtLocation, txtDate, txtTime, serviceType, txtPrice);
                }
            }
        });
    }

    private void registerClient(String name, String phoneNo, String location, String date, String time, String serviceType, String price) {

        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.show();
        String id = FirebaseDatabase.getInstance().getReference().push().getKey();
        Client client = new Client(name, phoneNo, location, date, time, serviceType, price);
        FirebaseDatabase.getInstance().getReference("Clients").child(id).setValue(client).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mProgressDialog.dismiss();
            }
        });

    }

    // checking services
    public String serviceChecked(){
        String service = null;
        if (liquid.isChecked() && powder.isChecked() && gel.isChecked()){
            service = "Liquid, Powder, Gel";
        } else if (liquid.isChecked() && powder.isChecked()){
            service = "Liquid, Powder";
        } else if (liquid.isChecked() && gel.isChecked()){
            service = "Liquid, Gel";
        } else if (powder.isChecked() && gel.isChecked()){
            service = "Powder, Gel";
        } else {
            service = null;
        }
        return service;
    }

    // showing date dialog
    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                dateView.setText(dayOfMonth + "/" + month + "/" + year);
            }
        },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    // setting up date method
//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        month+=1;
//        String datepick = "day/month/year: " + dayOfMonth + "/" + month + "/" + year;
//        date.setText(datepick);
//    }
}