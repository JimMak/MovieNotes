package com.makoudis.movienotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class NewMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie);

        final EditText editTxt_title = findViewById(R.id.editTxt_title);
        final EditText editTxt_notes = findViewById(R.id.editTxt_notes);
        Button btn_save = findViewById(R.id.btn_save);
        final Spinner spn_cat = findViewById(R.id.spn_cat);
        final RatingBar rating_grade = findViewById(R.id.rating_grade);

        String[] categories = getResources().getStringArray(R.array.Categories);

        ArrayAdapter adapter = new ArrayAdapter(NewMovieActivity.this,R.layout.category_item, R.id.txtVw_catItem ,categories);
        spn_cat.setAdapter(adapter);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie  = new Movie();
                movie.setTitle(editTxt_title.getText().toString());
                movie.setNotes(editTxt_notes.getText().toString());
                movie.setGrade(((int) rating_grade.getRating()));
                movie.setCategory(spn_cat.getSelectedItem().toString());
                movie.save( NewMovieActivity.this);

                NewMovieActivity.this.finish();


            }
        });


    }
}