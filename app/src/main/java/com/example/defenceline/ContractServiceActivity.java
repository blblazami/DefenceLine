package com.example.defenceline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ContractServiceActivity extends AppCompatActivity {

    private EditText name, phoneNo, location, price;
    private Button date, time, save;
    private CheckBox liquid, powder, gel;

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
    }
}