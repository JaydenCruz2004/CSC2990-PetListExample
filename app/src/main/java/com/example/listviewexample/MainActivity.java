package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import model.Pet;


public class MainActivity extends AppCompatActivity {
    ListView petListWidget;
    ArrayList<Pet> pets;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        petListWidget = findViewById(R.id.listViewWidget);

        Random ran = new Random();
        pets = new ArrayList<>();
        pets.add(new Pet("Kenny","Husky", 15));
        pets.add(new Pet("Zackary","Bulldog", 15));
        pets.add(new Pet("Winston","IDK", 15));
        pets.add(new Pet("Elijah","Corgi", ran.nextInt((20)+1)));


        int selection = 2;
        populateListView(selection);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String [] contents = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,contents);
        petListWidget.setAdapter(adapter);


    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
        ArrayAdapter<Pet> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pets);
        petListWidget.setAdapter(adapter);



    }
}