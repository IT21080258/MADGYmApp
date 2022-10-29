package com.example.olexogymmad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "gymDB.db";

    public DBHelper(Context context) {
        super(context, "gymDB.db", null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase gymDB) {
        gymDB.execSQL("create Table User(userName TEXT primary key ,password TEXT)");
        gymDB.execSQL("create Table Activity(activityDes TEXT primary key , day TEXT, time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase gymDB, int i, int i1) {
        gymDB.execSQL("drop table if exists User");
        gymDB.execSQL("drop table if exists Activity");
    }

    public boolean insertUserData(String userName, String password){
        SQLiteDatabase gymDB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", userName);
        contentValues.put("password", password);
        long result = gymDB.insert("User",null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean checkUsername(String userName){
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor = gymDB.rawQuery("select * from User where userName = ?",new String[] {userName});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkUserDetails(String userName, String password){
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor = gymDB.rawQuery("select * from User where userName = ? and password = ?",new String[] {userName,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    ////////////////Activity starts here
    public boolean insertActivity(String Activity, String Day, String Time){
        SQLiteDatabase gymDB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityDes", Activity);
        contentValues.put("day", Day);
        contentValues.put("time", Time);
        long result = gymDB.insert("Activity",null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean checkActivity( String Activity){
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor = gymDB.rawQuery("select * from Activity where activityDes = ?",new String[] {Activity});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkActivityLimit(){
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor = gymDB.rawQuery("select * from Activity where activityDes = ?",null);
        if(cursor.getCount()>2)
            return true;
        else
            return false;
    }

    public Cursor getActData(){
        SQLiteDatabase gymDB = getWritableDatabase();
        Cursor act = gymDB.rawQuery("Select * from Activity",null);
        return act;
    }

    public Boolean deleteActivityData(String Act)
    {
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor = gymDB.rawQuery("Select * from Activity where activityDes = ?", new String[]{Act});
        if(cursor.getCount()>0)
        {
            long result = gymDB.delete("Activity", "activityDes=?", new String[]{Act});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }



}
