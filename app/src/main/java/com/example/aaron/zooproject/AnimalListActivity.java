package com.example.aaron.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AnimalListActivity extends AppCompatActivity {

    RecyclerView rvAnimalList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    AnimalListAdaptor animalListAdaptor;
    List<Animal> animalList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);
        ZooDatabaseHelper zooDB = new ZooDatabaseHelper(this);

        Intent intent = getIntent();
        String catagory = (String)intent.getStringExtra("catagory");

        System.out.println("------------------------------->" + catagory);

       rvAnimalList = (RecyclerView)findViewById(R.id.rvAnimalList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvAnimalList.setLayoutManager(layoutManager);
        rvAnimalList.setItemAnimator(itemAnimator);
        ArrayList<Animal> list= zooDB.getAnimalList(catagory);
        Log.d("TAG", "onCreate: " + list.size());
        animalListAdaptor = new AnimalListAdaptor(list);
        rvAnimalList.setAdapter(animalListAdaptor);
        animalListAdaptor.notifyDataSetChanged();





    }


}
