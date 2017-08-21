package com.example.aaron.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CatagoryActivity extends AppCompatActivity {
    ListView lvCatagories;
    List<String> catagories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
        ZooDatabaseHelper zooDB = new ZooDatabaseHelper(this);
        catagories = zooDB.getCatagoriest();
        if(catagories.isEmpty()){
            zooDB.loadDatabase();
            catagories = zooDB.getCatagoriest();
        }

        lvCatagories = (ListView)findViewById(R.id.lvCatagories);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,catagories);
        lvCatagories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String catagory = lvCatagories.getItemAtPosition(i).toString();
                Intent intent = new Intent(view.getContext(), AnimalListActivity.class);
                intent.putExtra("catagory", catagory);
                startActivity(intent);
            }
        });
        lvCatagories.setAdapter(adapter);





    }
}
