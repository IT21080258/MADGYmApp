package com.example.lab1;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "gymDB.db";

    public DBHelper(Context context) {
        super(context, "gymDB.db", null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase gymDB) {
        gymDB.execSQL("create Table Booking (date TEXT primary key)");
        gymDB.execSQL("create Table Booking (Booking_Time)");
        gymDB.execSQL("create Table Booking(Duration TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase gymDB, int i, int i1) {
        gymDB.execSQL("drop table if exists Booking");
        //gymDB.execSQL("drop table if exists Booking_Time");
        //gymDB.execSQL("drop table if exists Duration");
    }

    //Insert Query
    public boolean insertUserData(String UserName,String date){

        SQLiteDatabase gymDB = getWritableDatabase();
        Cursor cursor =gymDB.rawQuery("select count(*) from Booking where UserName =?", new String[] {UserName});
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserName", UserName);
        int count= cursor.getCount()+1 ;
        contentValues.put("id", String.valueOf(count));
        contentValues.put("date", date);
        contentValues.put("Booking_Time", Booking_Time);
        contentValues.put("Duration", Duration);

        long result = gymDB.insert("Booking",null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updateuserdata(String UserName,String id, String date, String Booking_Time){
        SQLiteDatabase gymDB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("date", date);
        contentValues.put("Booking_Time", Booking_Time);
       // contentValues.put("Duration", Duration);

        Cursor cursor =gymDB.rawQuery("select * from Booking where UserName =? and id=?", new String[]  {UserName,id});
        if (cursor.getCount()>0){
            long result = gymDB.update("Booking", contentValues,"UserName=? and id=?", new String[]{UserName,id});
            if (result== -1){
                return false;

            }else {
                return true;
            }
        }else {
            return false;
        }


    }


    public boolean deletedata(String UserName, String id) {
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor =gymDB.rawQuery("select * from Booking where UserName =? and id=?", new String[]  {UserName,id});

        if (cursor.getCount() > 0) {
            long result = gymDB.delete("Booking",  "UserName=? and id=?", new String[]{UserName,id});
            if (result == -1) {
                return false;

            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getData(String UserName){
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor = gymDB.rawQuery("Select * from Booking where UserName =?",new String[]{UserName});
        return cursor;
    }









    /*public boolean checkActivity( String Activity){
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
    }*/


//read





}
