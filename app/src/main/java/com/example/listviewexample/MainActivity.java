package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import model.Pet;


public class MainActivity extends AppCompatActivity {
    ListView petListWidget;
    ArrayList<Pet> pets;

    AdapterView.OnItemClickListener selectedListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Pet selected = (Pet) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Hi :" + selected.getName(), Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Random ran = new Random();
        petListWidget = findViewById(R.id.listViewWidget);

        pets = new ArrayList<>();
        pets.add(new Pet("Kenny", "Husky", 15));
        pets.add(new Pet("Zackary", "Bulldog", 15));
        pets.add(new Pet("Winston", "IDK", 15));
        pets.add(new Pet("Elijah", "Corgi", ran.nextInt((20) + 1)));


        int selection = 2;
        populateListView(selection);

        petListWidget.setOnItemClickListener(selectedListener);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                petListWidget.setOnItemClickListener(selectedListener);
                break;
            case 3:
                usingTwoLines();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String[] contents = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, contents);
        petListWidget.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
        ArrayAdapter<Pet> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, pets);
        petListWidget.setAdapter(adapter);
    }

    private void usingTwoLines() {
        List<HashMap<String, String>> data = new ArrayList<>();
        for (Pet p : pets) {
            HashMap<String, String> current = new HashMap<>();
            current.put("name", p.getName());
            current.put("breed", p.getBreed());
            data.add(current);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "breed"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        petListWidget.setAdapter(adapter);
    }


}