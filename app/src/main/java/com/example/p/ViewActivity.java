package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ViewActivity extends AppCompatActivity {
    ListView lvdata;
    Button btnViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        lvdata = findViewById(R.id.lvData);
        btnViewBack = findViewById(R.id.btnViewBack);



        btnViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(ViewActivity.this,CalActivity.class);
                startActivity(j);
                finish();
            }
        });








    }
}
