package com.example.aaron.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AnimalInfoActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvCatagory;
    TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);
        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("animal");
        Animal animal = b.getParcelable("animal");
        Log.d("TAG", "onCreate: " + animal.getAnimalName());

        tvName = (TextView)findViewById(R.id.tvName);
        tvCatagory = (TextView)findViewById(R.id.tvCatagory);
        tvDetails = (TextView)findViewById(R.id.tvDetails);

        tvName.setText(animal.getAnimalName());
        tvCatagory.setText(animal.getAnimalCatagory());
        tvDetails.setText(animal.getAnimalDetails());
    }
}
