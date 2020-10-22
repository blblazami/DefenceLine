package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateVisitActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView visitDate, visitNumber, dateView, serviceProvider;
    private EditText name, placeHolder, notes;
    private ImageButton date;
    private Button save;

    // Progress Dialog
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_visit);

        visitDate = findViewById(R.id.datetextview);
        visitNumber = findViewById(R.id.visit_number);
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