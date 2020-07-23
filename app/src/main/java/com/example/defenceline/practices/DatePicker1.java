/*
package com.example.defenceline;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DatePicker1 {
    package com.example.defenceline;

    public class MainActivity extends AppCompatActivity {

        private static final String TAG = "MainActivity";
        private TextView mDisplayDate;
        private DatePickerDialog.OnDateSetListener mDateSetListener;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mDisplayDate = findViewById(R.id.tvDate_pick);

            mDisplayDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(
                            com.example.defenceline.MainActivity.this,
                            android.R.style.Theme_Black_NoTitleBar,
                            mDateSetListener,
                            year,month,day);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

            mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;

                    String date = month + "/" + dayOfMonth + "/" + year;
                    mDisplayDate.setText(date);
                }
            };

        }
    }
}
*/
