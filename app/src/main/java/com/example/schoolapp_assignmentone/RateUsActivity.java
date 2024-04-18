package com.example.schoolapp_assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RateUsActivity extends AppCompatActivity {

    private Button btnSubmit;
    private RatingBar ratingBar;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        btnSubmit = findViewById(R.id.buttonSubmit);
        ratingBar = findViewById(R.id.ratingBar);
        textViewResult = findViewById(R.id.ResultRateUs);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        // Display the username in the TextView


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueTotal = ratingBar.getNumStars()+"";
                String Rating = ratingBar.getRating()+"";
                textViewResult.setText("Thank You "+username+" For Rating!\n" + "Your Rating : "+Rating+"/"+valueTotal);

            }
        });

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "WELCOME BACK", Toast.LENGTH_LONG).show();
    }


}