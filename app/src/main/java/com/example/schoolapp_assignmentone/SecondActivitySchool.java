package com.example.schoolapp_assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivitySchool extends AppCompatActivity {
    private Spinner spinnerSubject;
    private TextView textViewGOTORATEUS;
    private EditText editTextName;
    private Button buttonSave;
    private RadioGroup radioGroup;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_school);
        spinnerSubject = findViewById(R.id.subject_spinner);
        textViewGOTORATEUS = findViewById(R.id.textView_Rate);
        buttonSave = findViewById(R.id.buttonSave);
        editTextName = findViewById(R.id.editTextName);
        radioGroup = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        spinnerAdapter.add("Find the animal of the character");
        spinnerAdapter.add("Math Operation");
        spinnerAdapter.add("Rate Us");
        spinnerSubject.setAdapter(spinnerAdapter);



        textViewGOTORATEUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRateUsPage = new Intent(SecondActivitySchool.this,RateUsActivity.class);
                startActivity(goToRateUsPage);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextName.getText().toString().trim();
                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", username );
                editor.apply();
                String str1 = editTextName.getText().toString().trim();
                String gender = radioButtonMale.isChecked() ? "Male" : "Female";
                String Subject = spinnerSubject.getSelectedItem().toString();
                if(str1.isEmpty() || Subject.isEmpty()){
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER ALL INFORMATION", Toast.LENGTH_LONG).show();

                }else {
                    if(Subject=="Find the animal of the character"){
                        Intent goNext = new Intent(SecondActivitySchool.this, TestActivity.class);
                        startActivity(goNext);
                    } else if (Subject=="Rate Us") {
                        Intent goNext = new Intent(SecondActivitySchool.this, RateUsActivity.class);
                        startActivity(goNext);
                    }else {
                        Intent goNext = new Intent(SecondActivitySchool.this, OperationActivity.class);
                        startActivity(goNext);
                    }
                }
            }
        });

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "WELCOME BACK", Toast.LENGTH_LONG).show();
    }


}