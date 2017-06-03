package com.siri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        moviesAdapter = new MoviesAdapter(movieList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // Divider
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // Adapter
        recyclerView.setAdapter(moviesAdapter);

        // Click Listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(final View view, final int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(final View view, final int position) {

            }
        }));

        prepareData();
    }

    private void prepareData() {
        movieList.add(new Movie("Mad Max: Fury Road", "Action & Adventure", "2015"));
        movieList.add(new Movie("Inside Out", "Animation, Kids & Family", "2015"));
        movieList.add(new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"));
        movieList.add(new Movie("Shaun the Sheep", "Animation", "2015"));
        movieList.add(new Movie("The Martian", "Science Fiction & Fantasy", "2015"));
        movieList.add(new Movie("Mission: Impossible Rogue Nation", "Action", "2015"));
        movieList.add(new Movie("Up", "Animation", "2009"));
        movieList.add(new Movie("Star Trek", "Science Fiction", "2009"));
        movieList.add(new Movie("The LEGO Movie", "Animation", "2014"));
        movieList.add(new Movie("Iron Man", "Action & Adventure", "2008"));
        movieList.add(new Movie("Aliens", "Science Fiction", "1986"));
        movieList.add(new Movie("Chicken Run", "Animation", "2000"));
        movieList.add(new Movie("Back to the Future", "Science Fiction", "1985"));
        movieList.add(new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981"));
        movieList.add(new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014"));

        moviesAdapter.notifyDataSetChanged();
    }
}
