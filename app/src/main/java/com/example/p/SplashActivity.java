package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread th = new Thread() {
            @Override
            public void run () {

                try {
                    sleep(3000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    Intent x = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(x);
                }

            }
        };
        th.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

