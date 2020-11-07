package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalActivity extends AppCompatActivity {
    TextView tvName,tvHeight,tvInch,tvWeight,tvFeet;
    Button btnCalculator,btnViewHistory;
    EditText etWeight;
    Spinner spnInch,spnFeet;
    SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        tvName = findViewById(R.id.tvName);
        tvHeight = findViewById(R.id.tvHeight);
        tvInch = findViewById(R.id.tvInch);
        tvWeight = findViewById(R.id.tvWeight);
        tvFeet = findViewById(R.id.tvFeet);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnViewHistory = findViewById(R.id.btnViewHistory);
        spnFeet = findViewById(R.id.spnFeet);
        spnInch = findViewById(R.id.spnInch);
        etWeight = findViewById(R.id.etWeight);
        sp = getSharedPreferences("userlogin", MODE_PRIVATE);
        String name = sp.getString("name","");
        tvName.setText("WELCOME " + name);

        final ArrayList<Integer> feet = new ArrayList<>();
        for(int i = 1 ; i<=12 ; i++) {
            feet.add(i);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item , feet);
        spnFeet.setAdapter(arrayAdapter);

        final ArrayList<Integer> inch = new ArrayList<>();
        for(int i = 0 ; i<=99 ; i++) {
            inch.add(i);
        }
        ArrayAdapter arrayAdapt = new ArrayAdapter(this, android.R.layout.simple_spinner_item , inch);
        spnInch.setAdapter(arrayAdapt);

       btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int in = new Integer(spnInch.getSelectedItem().toString());
                int fe = new Integer(spnFeet.getSelectedItem().toString());
                if(etWeight.getText().toString().length() == 0) {
                    etWeight.setError("Please enter some weight");
                    etWeight.requestFocus();
                    return;
                }

                double weight = new Double(etWeight.getText().toString());

                double inches = in*0.0254;
                double feets = fe*0.3048;
                double ht = inches + feets;
                final double res = Math.round(weight / (ht*ht));


                Toast.makeText(CalActivity.this, "BMI = " + res, Toast.LENGTH_SHORT).show();
                String r = Double.toString(res);
                Intent d = new Intent(CalActivity.this,ResActivity.class);
                d.putExtra ("result",r);
                startActivity(d);


            }
        });


    }
}
