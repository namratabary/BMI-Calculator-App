package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResActivity extends AppCompatActivity {
    TextView tvStatResult ,tvStatResult2 , tvStat1,tvStat2,tvStat3 , tvStat4;
    Button btnBack , btnShare ,btnSave;
    SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        tvStatResult = findViewById(R.id.tvStatResult);
        tvStatResult2 = findViewById(R.id.tvStatResult2);
        tvStat1 = findViewById(R.id.tvStat1);
        tvStat2 = findViewById(R.id.tvStat2);
        tvStat3 = findViewById(R.id.tvStat3);
        tvStat4 = findViewById(R.id.tvStat4);
        btnBack = findViewById(R.id.btnBack);
        btnShare = findViewById(R.id.btnShare);
        btnSave = findViewById(R.id.btnSave);

        sp = getSharedPreferences("userlogin", MODE_PRIVATE);
        final String name = sp.getString("name","");
        final String age = sp.getString("age","");
        final String phonenumber = sp.getString("phone number","");
        final String sex = sp.getString("sex","");

        Intent i = getIntent() ;
        final String r = i.getStringExtra("result");
        tvStatResult.setText("Your BMI is "+ r);

       tvStat1.setText("Below 18.5 is UnderWeight");
        tvStat2.setText("Between 18.5 to 25 is Normal");
        tvStat3.setText("Between 25 to 30 is OverWeight");
        tvStat4.setText("More than 30 is Obese");

        final Double x = Double.parseDouble(r);
        if(x < 18.5) {
            tvStatResult2.setText("You are UNDERWEIGHT");
            tvStatResult2.setTextColor(Color.MAGENTA);
            tvStat1.setText("Below 18.5 is UnderWeight");
            tvStat1.setTextColor(Color.RED);
        }
        else if (x >= 18.5 && x<= 25) {

            tvStatResult2.setText("Congooo You are Normal");
            tvStatResult2.setTextColor(Color.BLUE);
            tvStat2.setText("Between 18.5 to 25 is Normal");
            tvStat2.setTextColor(Color.RED);
        }
        else if(x >25 && x <= 30) {

            tvStatResult2.setText("You are OBEESEE");
            tvStatResult2.setTextColor(Color.BLACK);
            tvStat3.setText("Between 25 to 30 is Obese");
            tvStat3.setTextColor(Color.RED);
        }
        else {

            tvStatResult2.setText("You are too FATTT");
            tvStatResult2.setTextColor(Color.GREEN);
            tvStat4.setText("More than 30 is obese");
            tvStat4.setTextColor(Color.RED);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ResActivity.this , CalActivity.class);
                startActivity(a);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent();
                a.setAction(Intent.ACTION_SEND);
                String msg = ("Name :" + name + "\n Age :"+ age + "\n Sex :" + sex +
                        "\n Phone Number : " +phonenumber +
                        "\nBMI : " + x
                        + "\n" + tvStatResult2.getText());
                a.putExtra(Intent.EXTRA_TEXT,msg);
                a.setType("text/plain");
                Intent shareIntent = Intent.createChooser(a,null);
                String f = tvStatResult.getText().toString();
                a.putExtra("Key" , f);
                startActivity(shareIntent);

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });






    }
}
