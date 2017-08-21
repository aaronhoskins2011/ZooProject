package com.example.aaron.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AnimalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);
        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("animal");
        Animal animal = b.getParcelable("animal");
        Log.d("TAG", "onCreate: " + animal.getAnimalName());
    }
}
