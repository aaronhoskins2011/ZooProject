package com.example.aaron.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivIntroImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivIntroImage = (ImageView)findViewById(R.id.intoPic);
        ivIntroImage.setImageResource(R.drawable.zoointro);
    }

    public void onImageClick(View view) {
        Intent intent = new Intent(this,CatagoryActivity.class);
        view.getContext().startActivity(intent);
    }
}
