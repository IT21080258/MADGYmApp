package com.example.testing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "gymDB.db";

    public DBHelper(Context context) {
        super(context, "gymDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Exercises(Exercise TEXT primary key , rep TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
      DB.execSQL("drop Table if exists Exercises");
    }

    public boolean insertExercises(String Exercise, String reps) {
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Exercise", Exercise);
        contentValues.put("rep", reps);
        long result = DB.insert("Exercises", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


//    public boolean checkExercise(String Exercise) {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        Cursor cursor = DB.rawQuery("select * from User where Exercise = ?", new String[]{Exercise});
//        if (cursor.getCount() > 0) {
//            return true;
//        }
//        else {
//            return false;
//        }
//        }






    public Cursor getdata() {
        SQLiteDatabase DB = getWritableDatabase();
        Cursor e = DB.rawQuery("Select * from Exercises", null);
        return e;
    }


    public Boolean deleteExercise(String Ex)
    {
        SQLiteDatabase gymDB = this.getWritableDatabase();
        Cursor cursor = gymDB.rawQuery("Select * from Exercises where Exercise = ?", new String[]{Ex});
        if(cursor.getCount()>0)
        {
            long result = gymDB.delete("Exercises", "Exercise=?", new String[]{Ex});
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
