/*
package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private CheckBox mGel, mPowder, mLiquid;
    private Button mButton;
    private TextView mTextView;
    private ArrayList<String> mResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGel = findViewById(R.id.gel_chkbox);
        mPowder = findViewById(R.id.powder_chkbox);
        mLiquid = findViewById(R.id.liquid_chkbox);

        mButton = findViewById(R.id.result_btn);
        mTextView = findViewById(R.id.show_result);
        mResults = new ArrayList<>();
        mTextView.setEnabled(false);

        mGel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mGel.isChecked())
                    mResults.add("Gel");
                else
                    mResults.remove("Gel");
            }
        });

        mPowder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPowder.isChecked())
                    mResults.add("Powder");
                else
                    mResults.remove("Powder");
            }
        });

        mLiquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLiquid.isChecked())
                    mResults.add("Liquid");
                else
                    mResults.remove("Liquid");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s: mResults)
                    stringBuilder.append(s).append("\n");

                mTextView.setText(stringBuilder.toString());
                mTextView.setEnabled(false);
            }
        });
    }

}*/
