package com.srjlove.impetusregistration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by comp24 on 11/15/2017.
 */
public class DbHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "officedata.db";
    public static final String TABLE_NAME = "user";
    private static final int DB_VERSION = 1;
    public static final String FULL_NAME = "fname";
    public static final String LAST_NAME = "lname";
    public static final String MOB = "mobile";
    public static final String EMAIL = "email";
    public static final String PASS = "pass";
    public static final String IMAGE = "image";

    public DbHelper(Context contex) {
        super(contex, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "( "
                + FULL_NAME + " TEXT" + " , "
                + LAST_NAME + " TEXT" + " , "
                + MOB + " INTEGER(10)" + " , "
                + EMAIL + " TEXT" + " , "
                + PASS + " INTEGER(4)" + " , "
                + IMAGE + " BLOB" + " );"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
