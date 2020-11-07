/*package com.example.p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "USERBMI.db";

    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_ID = "userId";
    public static final String COLUMN_FIRST_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_BMI= "bmi";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_AGE + " TEXT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_BMI + " NUMERIC " + ")" ;


    public DatabaseHelper(Context context){
        super(context,"USERBMI.db",null,1);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
       db.execSQL(TABLE_CREATE);
    }
}

  */

