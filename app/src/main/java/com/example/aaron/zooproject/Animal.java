package com.example.aaron.zooproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaron on 8/11/17.
 */

class Animal implements Parcelable{
    String animalName;
    String animalCatagory;
    String animalDetails;
    String animalSoundLocation;

    public Animal(String animalName, String animalCatagory, String animalDetails, String animalSoundLocation) {
        this.animalName = animalName;
        this.animalCatagory = animalCatagory;
        this.animalDetails = animalDetails;
        this.animalSoundLocation = animalSoundLocation;
    }

    protected Animal(Parcel in) {
        animalName = in.readString();
        animalCatagory = in.readString();
        animalDetails = in.readString();
        animalSoundLocation = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalCatagory() {
        return animalCatagory;
    }

    public void setAnimalCatagory(String animalCatagory) {
        this.animalCatagory = animalCatagory;
    }

    public String getAnimalDetails() {
        return animalDetails;
    }

    public void setAnimalDetails(String animalDetails) {
        this.animalDetails = animalDetails;
    }

    public String getAnimalSoundLocation() {
        return animalSoundLocation;
    }

    public void setAnimalSoundLocation(String animalSoundLocation) {
        this.animalSoundLocation = animalSoundLocation;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(animalName);
        dest.writeString(animalCatagory);
        dest.writeString(animalDetails);
        dest.writeString(animalSoundLocation);
    }
}
