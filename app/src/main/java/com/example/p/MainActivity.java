package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvPersonalDetails;
    EditText etName, etAge, etPhoneNumber;
    RadioGroup rgGender;
    RadioButton rb;
    Button btnRegister;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPersonalDetails = findViewById(R.id.tvPersonalDetails);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        rgGender = findViewById(R.id.rgGender);
        btnRegister = findViewById(R.id.btnRegister);

       sp = getSharedPreferences("userlogin", MODE_PRIVATE);
       try {

           String n = sp.getString("name", "");
           if (n.length() != 0) {
               Intent a = new Intent(MainActivity.this, CalActivity.class);
               startActivity(a);
               finish();
           }
           sp = getSharedPreferences("userlogin", MODE_PRIVATE);

           String ag = sp.getString("age", "");

           if (ag.length() != 0) {
               Intent b = new Intent(MainActivity.this, CalActivity.class);
               startActivity(b);
               finish();
           }


           sp = getSharedPreferences("userlogin", MODE_PRIVATE);
           String ge = sp.getString("sex", "");
           if (ge.length() != 0) {
               Intent e = new Intent(MainActivity.this, CalActivity.class);
               startActivity(e);
               finish();
           }



           sp = getSharedPreferences("userlogin", MODE_PRIVATE);

           String pn = sp.getString("phone number", "");

           if (pn.length() != 0) {
               Intent c = new Intent(MainActivity.this, CalActivity.class);
               startActivity(c);
               finish();
           } else {
               btnRegister.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       String name = etName.getText().toString();
                       if (name.length() == 0) {
                           etName.setError("name is improper");
                           etName.requestFocus();
                           return;
                       }
                       String age = etAge.getText().toString();
                       if (age.length() == 0) {
                           etAge.setError("Age is improper");
                           etAge.requestFocus();
                           return;
                       }
                       String phno = etPhoneNumber.getText().toString();
                       if (phno.length() != 10) {
                           etPhoneNumber.setError("Phone number is improper");
                           etPhoneNumber.requestFocus();
                           return;
                       }

                        int id = rgGender.getCheckedRadioButtonId();
                        RadioButton rb = findViewById(id);
                       String sex = rb.getText().toString();
                       if (sex == null) {
                           Toast.makeText(MainActivity.this, "Please select a gender", Toast.LENGTH_SHORT).show();
                           return;
                       }

                       SharedPreferences.Editor editor = sp.edit();
                       editor.putString("name", name);
                       editor.commit();
                       Intent a = new Intent(MainActivity.this, CalActivity.class);
                       startActivity(a);
                       finish();
                       SharedPreferences.Editor e = sp.edit();
                       e.putString("age", age);
                       e.commit();
                       Intent b = new Intent(MainActivity.this, CalActivity.class);
                       startActivity(b);
                       finish();

                       SharedPreferences.Editor edi = sp.edit();
                       edi.putString("phone number", phno);
                       edi.commit();
                       Intent c = new Intent(MainActivity.this, CalActivity.class);
                       startActivity(c);
                       finish();

                       SharedPreferences.Editor ed = sp.edit();
                       ed.putString("sex", sex);
                       ed.commit();
                       Intent g = new Intent(MainActivity.this, CalActivity.class);
                       startActivity(g);
                       finish();






                   }
               });
           }
       }
       catch (Exception e) {
           Toast.makeText(this, "Some issue please check your filled info", Toast.LENGTH_LONG).show();
           return;
       }

        }
    }

