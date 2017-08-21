package com.example.aaron.zooproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 8/11/17.
 */

public class AnimalListAdaptor extends RecyclerView.Adapter<AnimalListAdaptor.ViewHolder> {
    List<Animal> animalList = new ArrayList<>();

    public AnimalListAdaptor(List<Animal> animalList) {
        this.animalList = animalList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvAnimalName;

        public ViewHolder(View itemView){
            super(itemView);
            tvAnimalName = (TextView)itemView.findViewById(R.id.tvAnimalName);
        }


    }
    public AnimalListAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.anamal_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalListAdaptor.ViewHolder holder, int position) {
        final Animal animal = animalList.get(position);
        holder.tvAnimalName.setText(animal.getAnimalName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),AnimalInfoActivity.class);
                Bundle b = new Bundle();
                b.putParcelable("animal" , animal);
                intent.putExtra("animal", b);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

}
