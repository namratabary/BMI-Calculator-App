package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class FeedbackActivity extends AppCompatActivity {
    RadioGroup rgFeedback;
    TextView tvRating, tvhappy;
    RadioButton rbFantastic , rbExcellent ,rbSuperb;
    CheckBox cbNotes , cbSoftware , cbCertificate;
    Button btnSubmit;
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        tvRating = findViewById(R.id.tvRating);
        tvhappy = findViewById(R.id.tvhappy);
        rgFeedback = findViewById(R.id.rgFeedback);
        rbFantastic =  findViewById(R.id.rbFantastic);
        rbExcellent = findViewById(R.id.rbExcellent);
        rbSuperb = findViewById(R.id.rbSuperb);
        cbNotes = findViewById(R.id.cbNotes);
        cbSoftware = findViewById(R.id.cbSoftware);
        cbCertificate = findViewById(R.id.cbCertificate);
        btnSubmit = findViewById(R.id.btnSubmit);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR)
                    tts.setLanguage(Locale.ENGLISH);

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rgFeedback.getCheckedRadioButtonId();
                RadioButton rb = findViewById(id);
                String fb = rb.getText().toString();
                String mat = "";
                if(cbNotes.isChecked())
                    mat = mat + "Efficient ";
                if(cbSoftware.isChecked())
                    mat = mat + "Software ";
                if(cbCertificate.isChecked())
                    mat = mat + "Accurate ";

                String msg = "Our Features were " + fb + "\n You are happy with our " + mat + " performance \n Thank You";

                Toast.makeText(FeedbackActivity.this,msg ,Toast.LENGTH_LONG).show();

                tts.speak(msg , TextToSpeech.QUEUE_FLUSH,null);
            }
        });




    }
    long bpt;
    @Override
    public void onBackPressed(){
        if(bpt + 1500 > System.currentTimeMillis())
        { super.onBackPressed();}
        else
        {Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            bpt = System.currentTimeMillis(); }
    }

}
