package com.makoudis.movienotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Movie> movies;
    private Context context;

    public MyAdapter(ArrayList<Movie> movies, Context context){
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row  = inflater.inflate(R.layout.category_item, parent, false);
        MyViewHolder item = new MyViewHolder(row);
        return item;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row  = inflater.inflate(R.layout.movie_item, parent, false);
        MyViewHolder item = new MyViewHolder(row);
        return item;

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {
        ((MyViewHolder)holder).txtVw_id.setText(String.valueOf(this.movies.get(position).getId()));
        ((MyViewHolder)holder).txtVw_title.setText(this.movies.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ViewMovie.class);
                int id = movies.get(position).getId();

                intent.putExtra("movie_id", id);

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtVw_id;
        TextView txtVw_title;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVw_id = itemView.findViewById(R.id.txtVw_id);
            txtVw_title = itemView.findViewById(R.id.txtVw_title);

        }
    }

}
