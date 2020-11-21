package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.defenceline.model.Visit;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateVisitActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView visitDate, dateView, serviceProvider;
    private EditText name, placeHolder, notes, visitNumber;
    private ImageButton date;
    private Button save;

    // Progress Dialog
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_visit);

        visitDate = findViewById(R.id.datetextview);
        visitNumber = findViewById(R.id.visit_number_view);
        serviceProvider = findViewById(R.id.service_provider);
        name = findViewById(R.id.client_name);
        placeHolder = findViewById(R.id.place_holder);
        notes = findViewById(R.id.notes);
        date = findViewById(R.id.choose_date_btn_id);
        dateView = findViewById(R.id.date_view);
        save = findViewById(R.id.save_button);

        mProgressDialog = new ProgressDialog(this);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // to show date on text view
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        visitDate.setText(df.format(dateobj));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtVisitDate = visitDate.getText().toString();
                String txtVisitNumber = visitNumber.getText().toString();
                String txtName = name.getText().toString();
                String txtPlaceHolder = placeHolder.getText().toString();
                String txtServiceProvider = serviceProvider.getText().toString();
                String txtDateView = dateView.getText().toString();
                String txtNotes = notes.getText().toString();

                if (TextUtils.isEmpty(txtVisitDate) || TextUtils.isEmpty(txtVisitNumber)
                || TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtPlaceHolder)
                || TextUtils.isEmpty(txtServiceProvider) || TextUtils.isEmpty(txtDateView)){
                    Toast.makeText(CreateVisitActivity.this, "Mandatory Missed", Toast.LENGTH_SHORT).show();
                } else {
                    createVisit(txtVisitDate, txtVisitNumber, txtName, txtPlaceHolder, txtServiceProvider, txtDateView, txtNotes);
                }
            }
        });

    }

    private void createVisit(String visitDate, String visitNumber, String name, String placeHolder, String serviceProvider, String dateView, String notes) {

        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.show();
        String id = FirebaseDatabase.getInstance().getReference().push().getKey();
        Visit visit = new Visit(visitDate, visitNumber, name, placeHolder, serviceProvider, dateView, notes);
        FirebaseDatabase.getInstance().getReference("Visits").child(id).setValue(visit).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mProgressDialog.dismiss();
            }
        });

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
}