package com.example.sqlite_tutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "person.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create_statement="CREATE TABLE CUSTOMER_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AGE INT, IS_ACTIVE BOOL)";
        db.execSQL(sql_create_statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean add_new_row(Person person){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("NAME",person.getName());
        cv.put("AGE",person.getAge());
        cv.put("IS_ACTIVE",person.isIs_active());

        long insert = db.insert("CUSTOMER_TABLE", null, cv);

        return insert!=-1;
    }

    public List<Person> getList(){
        List<Person> list =new ArrayList<>();
        String sql_select_statement="SELECT * FROM CUSTOMER_TABLE";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select_statement,null);

        if(cursor.moveToFirst()){
            do{
                String name=cursor.getString(1);
                int age=cursor.getInt(2);
                boolean is_active= cursor.getInt(3)==1;

                Person person=new Person(name,age,is_active);
                list.add(person);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}

