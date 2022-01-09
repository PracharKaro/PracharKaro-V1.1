package com.example.collegeproject.dataRegister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.collegeproject.model.UsersDetails;
import com.example.collegeproject.paramaterRegister.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public  MyDbHandler(Context context){
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       String create = "CREATE TABLE " + Params.TABLE_NAME + "("
               + Params.KEY_NAME+ "TEXT," + Params.KEY_EMAIL + "TEXT,"
               + Params.KEY_PASSWORD+"TEXT,"+ Params.KEY_PHONE +
               "INTEGER PRIMARY KEY," + ")";
        Log.d("dbPiyush","QUERY IS BEING RUN"+ create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("drop Table if exists"+ Params.TABLE_NAME);
    }

    public boolean addDetails(UsersDetails ud){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME,ud.getName());
        values.put(Params.KEY_EMAIL,ud.getEmail());
        values.put(Params.KEY_PHONE,ud.getPhone());
        values.put(Params.KEY_PASSWORD,ud.getPassword());

        long insert = db.insert(Params.TABLE_NAME,null,values);
        //Log.d("dbPiyush","Successfully inserted");
        db.close();
        if(insert==-1) {
            return false;
        }
        else {
            return true;
        }
    }
    public List<UsersDetails> getAllDetails(){
        List<UsersDetails> detailsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Generate the query to read from the database
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        //Loop through cursor
        if(cursor.moveToFirst()){
            do{
                UsersDetails usersDetails = new UsersDetails();
                usersDetails.setName(cursor.getString(0));
                usersDetails.setEmail(cursor.getString(1));
                usersDetails.setPhone(Integer.parseInt(cursor.getString(3)));
                usersDetails.setPassword(cursor.getString(4));
                detailsList.add(usersDetails);
            }while(cursor.moveToNext());
        }
        return detailsList;
    }
}
