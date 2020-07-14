package com.makoudis.movienotes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLliteHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "movies_db.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_MOVIES = "movies";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_GRADE = "grade";
    public static final String COLUMN_NOTES = "notes";


    public SQLliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_MOVIES+" (" +
                COLUMN_ID+" integer primary key autoincrement, " +
                COLUMN_TITLE+" text not null, " +
                COLUMN_CATEGORY+" text not null, " +
                COLUMN_GRADE+" int not null, "+
                COLUMN_NOTES+" text not null);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
