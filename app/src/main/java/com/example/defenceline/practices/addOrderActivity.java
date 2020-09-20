/*
package com.example.defenceline.practices;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


import com.example.defenceline.MainActivity;
import com.example.defenceline.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addOrderActivity extends AppCompatActivity {
    private TextView date;
    private EditText dateOfReceipt;
    private EditText fabricAndColor;
    private EditText tailorName;
    private EditText kindOfEmb;
    private EditText additionalMaterial;
    private EditText phone;
    private EditText price;
    private EditText deposit;
    private EditText remaining;
    private TextView orderNum;
    private EditText orderStatus;
    private Button AddOrder;
    private Toolbar mMainToolbar;
    private FirebaseDatabase mDatabase;
    private FirebaseUser mUser;
    private DatabaseReference mRef;
    private FirebaseAuth mAuth;
    private String OsId;
    private SharedPreferences mPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        date = findViewById(R.id.dateTextView);
        dateOfReceipt = findViewById(R.id.DateOfReceiptText);
        fabricAndColor = findViewById(R.id.fabricAndColorText);
        tailorName = findViewById(R.id.TailorNameText);
        kindOfEmb = findViewById(R.id.KindOfEmpText);
        additionalMaterial = findViewById(R.id.AdditionalMaterialText);
        phone= findViewById(R.id.phoneText);
        price = findViewById(R.id.priceText);
        deposit = findViewById(R.id.DepositText);
        remaining = findViewById(R.id.RemainingText);
        orderNum = findViewById(R.id.orderNumTextView2);
        orderStatus = findViewById(R.id.OrderStatusText);
        AddOrder = findViewById(R.id.AddOrderButton);
        mMainToolbar = findViewById(R.id.toolbar);

        mPreferences = getSharedPreferences("OsDB", MODE_PRIVATE);
        OsId =mPreferences.getString("OsId","1001");

        orderNum.setText(OsId);


        setSupportActionBar(mMainToolbar);
        getSupportActionBar().setTitle("Order Information");

        mDatabase = FirebaseDatabase.getInstance();

        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        date.setText(df.format(dateobj));


        AddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pureDate = date.getText().toString();
                final String pureDateOfRec = dateOfReceipt.getText().toString();
                final String pureFabricAndColor = fabricAndColor.getText().toString();
                final String pureTailorName = tailorName.getText().toString();
                final String pureKindOfEmb = kindOfEmb.getText().toString();
                final String pureAdditionalMaterial = additionalMaterial.getText().toString();
                final String purePhone = phone.getText().toString();
                final String purePrice = price.getText().toString();
                final String pureDeposit = deposit.getText().toString();
                final String pureRemaining = remaining.getText().toString();
                final String pureOrderNum = orderNum.getText().toString();
                final String pureOrderStatus = orderStatus.getText().toString();

                SharedPreferences.Editor prefEditor = mPreferences.edit();
                int tmp = Integer.parseInt(OsId);
                tmp = tmp + 1;
                OsId = String.valueOf(tmp);
                prefEditor.putString("OsId", OsId);
                prefEditor.commit();

                if (!TextUtils.isEmpty(pureDate) && !TextUtils.isEmpty(pureDateOfRec) && !TextUtils.isEmpty(pureFabricAndColor) &&
                        !TextUtils.isEmpty(pureTailorName) && !TextUtils.isEmpty(pureKindOfEmb)&&
                        !TextUtils.isEmpty(pureAdditionalMaterial) && !TextUtils.isEmpty(purePhone)&&
                        !TextUtils.isEmpty(purePrice) && !TextUtils.isEmpty(pureDeposit)&&
                        !TextUtils.isEmpty(pureRemaining) && !TextUtils.isEmpty(pureOrderNum)&&
                        !TextUtils.isEmpty(pureOrderStatus)) {
                    Intent x = new Intent(getApplicationContext(), CustomerNamesActivity.class);
                    x.putExtra("date", pureDate);
                    x.putExtra("dateOfReceipt", pureDateOfRec);
                    x.putExtra("FabricAndColor", pureFabricAndColor);
                    x.putExtra("TailorName", pureTailorName);
                    x.putExtra("kindOfEmb", pureKindOfEmb);
                    x.putExtra("AdditionalMaterial", pureAdditionalMaterial);
                    x.putExtra("phone", purePhone);
                    x.putExtra("price", purePrice);
                    x.putExtra("deposit", pureDeposit);
                    x.putExtra("remaining", pureRemaining);
                    x.putExtra("orderNum", pureOrderNum);
                    x.putExtra("orderStatus", pureOrderStatus);

                    startActivity(x);
                    finish();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Please fill all the required information First", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    // Connecting the main menu to news activity
    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.main_menu,m);
        return true;
    }
    //actions happens when Items of the menu are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signOutItem:
                Signout();
                return true;
            case R.id.aboutItem:
                Intent aboutIntent = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(aboutIntent);
                return true;
            case R.id.settingItem:
                return true;
            case R.id.accountItem:
                Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(profileIntent);

                return true;


            default:
                return false;
        }
    }
    public void Signout(){
        mAuth.signOut();
        Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(loginIntent);
        finish();

    }
}
*/
