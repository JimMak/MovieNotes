package com.makoudis.movienotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class Movie {

    private int id;
    private String title;
    private String category;
    private int grade;
    private String notes;


    private static final String[] columns = {SQLliteHelper.COLUMN_ID,
            SQLliteHelper.COLUMN_TITLE,
            SQLliteHelper.COLUMN_CATEGORY,
            SQLliteHelper.COLUMN_GRADE,
            SQLliteHelper.COLUMN_NOTES
    };

    public Movie(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void save(Context context){
        //Log.d("Sql",this.title+" "+this.category+" "+this.notes+" "+this.grade);
        SQLliteHelper sqLliteHelper = new SQLliteHelper(context);
        SQLiteDatabase database = sqLliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SQLliteHelper.COLUMN_TITLE, this.title);
        values.put(SQLliteHelper.COLUMN_CATEGORY, this.category);
        values.put(SQLliteHelper.COLUMN_GRADE, this.grade);
        values.put(SQLliteHelper.COLUMN_NOTES, this.notes);

        database.insert(SQLliteHelper.TABLE_MOVIES, null, values);
    }

    public static ArrayList<Movie> getAllMovies(Context context){
        ArrayList<Movie> movies = new ArrayList<>();

        SQLliteHelper helper = new SQLliteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        Cursor cursor = database.query(SQLliteHelper.TABLE_MOVIES, columns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Movie movie = new Movie();
            movie.id = cursor.getInt(0);
            movie.title = cursor.getString(1);
            movie.grade = cursor.getInt(2);
            movie.category = cursor.getString(3);
            movie.notes = cursor.getString(4);


            Log.d("SQL_MOVIE", movie.title);

            movies.add(movie);

            cursor.moveToNext();
        }
        return movies;
    }
}
