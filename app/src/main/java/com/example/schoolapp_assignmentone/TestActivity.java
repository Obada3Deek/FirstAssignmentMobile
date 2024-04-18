package com.example.schoolapp_assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private Spinner characterSpinner;
    private ListView listViewAnimals;
    private Button btnOK;
    private List<String> listOfAnimals;
    private String[] animals = {"Alligator","Fish","Dolphin","Whale","Shark","Jellyfish","Crab","Sea lion","Sea otter","Seahorse","Moray eel","Bear","Cat","Dog","Elephant","Fox","Gorilla","Hippopotamus","Iguana","Jaguar","Kangaroo","Lion","Monkey","Newt","Octopus","Panda","Quokka","Rabbit","Snake","Tiger","Uakari","Vulture","Walrus","Xenopus","Yak","Zebra"};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        characterSpinner = findViewById(R.id.character_spinner);
        btnOK = findViewById(R.id.button_ok);
        listViewAnimals = findViewById(R.id.animal_list_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.characters_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        characterSpinner.setAdapter(adapter);
        listOfAnimals = new ArrayList<>(Arrays.asList(animals));

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResultOfSearch();
            }
        });
        listViewAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){
                    Intent GoTheLink = new Intent(TestActivity.this,LinkOfPhoto.class);
                    startActivity(GoTheLink);

                }else{
                    Toast.makeText(getApplicationContext(),"Click on the first item :",Toast.LENGTH_SHORT).show();

                }
            }
        });




    }

    private void showResultOfSearch(){
        String Selected = characterSpinner.getSelectedItem().toString().toUpperCase();
        List<String> filteredList = new ArrayList<>();
        for(String animal : animals){
            if(animal.toUpperCase().startsWith(Selected)){
                filteredList.add(animal);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, filteredList);
        listViewAnimals.setAdapter(adapter);
        listViewAnimals.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "WELCOME BACK", Toast.LENGTH_LONG).show();
    }
}