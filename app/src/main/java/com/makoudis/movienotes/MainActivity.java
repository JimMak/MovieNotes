package com.makoudis.movienotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rclrVw);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Button btn_movieact = findViewById(R.id.btn_movie_act);

        btn_movieact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewMovieActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Movie> movies = Movie.getAllMovies(MainActivity.this);

        mAdapter = new MyAdapter(movies, MainActivity.this);
        recyclerView.setAdapter(mAdapter);


    }
}