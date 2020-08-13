package com.makoudis.movienotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ViewMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movie);

        int movie_id = getIntent().getExtras().getInt("movie_id");

        final Movie movie = new Movie(movie_id, ViewMovie.this);

        Log.d("SQL_USER", movie.getTitle());

        final EditText edTxt_id = findViewById(R.id.editTXT_id);
        final EditText edTxt_title = findViewById(R.id.editTxt_title);
        final Spinner view_spn = findViewById(R.id.view_spn);
        final EditText edTxt_grade = findViewById(R.id.editTxt_grade);
        final EditText edTxt_notes = findViewById(R.id.editTXT_notes);

        String[] categories = getResources().getStringArray(R.array.Categories);

        ArrayAdapter adapter = new ArrayAdapter(ViewMovie.this,R.layout.category_item, R.id.txtVw_catItem ,categories);
        view_spn.setAdapter(adapter);

        edTxt_title.setText(movie.getTitle());
        edTxt_grade.setText(String.valueOf(movie.getGrade()));
        edTxt_notes.setText(movie.getNotes());
        view_spn.setSelection(this.GetIndexFromString(categories, movie.getCategory()));


    }

    private int GetIndexFromString(String[] categories, String category){
        for (int i=0;i<categories.length;i++) {
            if (categories[i].equals(category)) {
                return i;
            }
        }
        return 0;
    }
}