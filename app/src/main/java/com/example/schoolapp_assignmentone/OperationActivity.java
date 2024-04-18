package com.example.schoolapp_assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OperationActivity extends AppCompatActivity {
    private Spinner spinnerOp;
    private TextView textViewRate,textViewResult;
    private Button btnCalculate,btnRestart;
    private EditText editTextNumberOne,editTextNumberTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        spinnerOp = findViewById(R.id.OP_spinner);
        textViewResult = findViewById(R.id.ResultRateUs);
        textViewRate = findViewById(R.id.textViewRatePage);
        editTextNumberOne = findViewById(R.id.editTextNumberOne);
        editTextNumberTwo = findViewById(R.id.editTextNumberTwo);
        btnRestart = findViewById(R.id.buttonRestart);
        btnCalculate = findViewById(R.id.buttonClickRes);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        spinnerAdapter.add("-");
        spinnerAdapter.add("+");
        spinnerAdapter.add("*");
        spinnerAdapter.add("/");
        spinnerOp.setAdapter(spinnerAdapter);

        textViewRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goNext = new Intent(OperationActivity.this,RateUsActivity.class);
                startActivity(goNext);
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NumberOne = editTextNumberOne.getText().toString();
                String NumberTwo = editTextNumberTwo.getText().toString();
                String Operation = spinnerOp.getSelectedItem().toString();
                double num1 = Double.parseDouble(NumberOne);
                double num2 = Double.parseDouble(NumberTwo);
                double finalResult;
                if(NumberOne.isEmpty() || NumberTwo.isEmpty()){
                   Toast.makeText(getApplicationContext(),"Please enter all Numbers and Operation",Toast.LENGTH_SHORT).show();

                }else if(Operation=="+"){
                        finalResult = num1+num2;
                        textViewResult.setText("The Result of "+num1+" + "+num2+" = "+finalResult);

                    } else if (Operation=="-") {
                        finalResult = num1-num2;
                    textViewResult.setText("The Result of "+num1+" - "+num2+" = "+finalResult);

                    } else if (Operation=="*") {
                        finalResult = num1*num2;
                    textViewResult.setText("The Result of "+num1+" * "+num2+" = "+finalResult);

                    }else {
                        if(num2==0){
                            textViewResult.setText("Not acceptaple devide by 0.");
                        }else {
                            finalResult = num1 / num2;
                            textViewResult.setText("The Result of "+num1+" / "+num2+" = "+finalResult);
                        }

                    }
                }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumberOne.setText("");
                editTextNumberTwo.setText("");
                textViewResult.setText("Cleared Successfully!!");
            }
        });


    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "WELCOME BACK", Toast.LENGTH_LONG).show();
    }

}