package com.example.aaron.zooproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 8/20/17.
 */

public class ZooDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "zooDatabase";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "ZooTable";
    public static final String ANIMAL_NAME = "Name";
    public static final String ANIMAL_CATAGORY = "Catagory";
    public static final String ANIMAL_DETAILS = "Details";
    public static final String ANIMAL_SOUND = "Sound";
    public static final String TAG = "DATABASE_HELPER";
    List<Animal> animalList = new ArrayList<>();

    public ZooDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( "
                + ANIMAL_NAME + " TEXT PRIMARY KEY, "
                + ANIMAL_CATAGORY + " TEXT, "
                + ANIMAL_DETAILS + " TEXT, "
                + ANIMAL_SOUND + " TEXT )";
        db.execSQL(CREATE_TABLE);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    public void loadDatabase(){

        initAnamals();
        for(int i = 0; i < animalList.size(); i++){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ANIMAL_NAME, animalList.get(i).getAnimalName());
            cv.put(ANIMAL_CATAGORY, animalList.get(i).getAnimalCatagory());
            cv.put(ANIMAL_DETAILS,animalList.get(i).getAnimalDetails());
            cv.put(ANIMAL_SOUND, animalList.get(i).getAnimalSoundLocation());
            db.insert(TABLE_NAME,null,cv);
        }

    }

    public ArrayList<String> getCatagoriest(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT DISTINCT " + ANIMAL_CATAGORY + " FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<String> returnList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                returnList.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        return returnList;
    }
    public ArrayList<Animal> getAnimalList(String catagory){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Animal> returnList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + ANIMAL_CATAGORY + " = \"" + catagory + "\"";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Animal tempAnimal = new Animal(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                returnList.add(tempAnimal);

            }while(cursor.moveToNext());
        }
        return returnList;

    }

    public void initAnamals(){
        animalList.add(new Animal("Blue and Gold Macow","Bird","Details",""));
        animalList.add(new Animal("Grey Amazon","Bird","Details",""));
        animalList.add(new Animal("Chicken","Bird","Details",""));
        animalList.add(new Animal("Duck","Bird","Details",""));
        animalList.add(new Animal("Mocking Bird","Bird","Details",""));
        animalList.add(new Animal("Cobra","Reptile","Details",""));
        animalList.add(new Animal("Bearded Dragon","Reptile","Details",""));
        animalList.add(new Animal("Aligator","Reptile","Details",""));
        animalList.add(new Animal("Dragon","Reptile","Details",""));
        animalList.add(new Animal("Raddle Snake","Reptile","Details",""));
        animalList.add(new Animal("Human","Mammal","Details",""));
        animalList.add(new Animal("Mouse","Mammal","Details",""));
        animalList.add(new Animal("Ape","Mammal","Details",""));
        animalList.add(new Animal("Gorilla","Mammal","Details",""));
        animalList.add(new Animal("Cow","Mammal","Details",""));

    }
}
