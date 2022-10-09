package com.example.olexogymmad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "user.db";

    public DBHelper(Context context) {
        super(context, "user.db", null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase gymDB) {
        gymDB.execSQL("create Table User(userName TEXT primary key ,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase gymDB, int i, int i1) {
        gymDB.execSQL("drop table if exists User");
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
}
