package com.rullierGwen.android.myapplication;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.rullierGwen.android.myapplication.Models.Movie;
import com.rullierGwen.android.myapplication.Models.MovieJSON;
import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MovieActivity extends AppCompatActivity {

    private MovieJSON mMovie;
    FloatingActionButton fab ;

    private TextView mTitre, mDate, mGenre, mPropos, mDirector, mActor, mAward ;
    ImageView mImage ;

    String strJSON = "{\n" +
            "\"Title\": \"Star Wars: Episode IV - A New Hope\",\n" +
            "\"Year\": \"1977\",\n" +
            "\"Rated\": \"PG\",\n" +
            "\"Released\": \"25 May 1977\",\n" +
            "\"Runtime\": \"121 min\",\n" +
            "\"Genre\": \"Action, Adventure, Fantasy, Sci-Fi\",\n" +
            "\"Director\": \"George Lucas\",\n" +
            "\"Writer\": \"George Lucas\",\n" +
            "\"Actors\": \"Mark Hamill, Harrison Ford, Carrie Fisher, Peter Cushing\",\n" +
            "\"Plot\": \"The Imperial Forces, under orders from cruel Darth Vader, hold Princess Leia hostage in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker and Han Solo, captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 and C-3PO to rescue the beautiful princess, help the Rebel Alliance and restore freedom and justice to the Galaxy.\",\n" +
            "\"Language\": \"English\",\n" +
            "\"Country\": \"USA\",\n" +
            "\"Awards\": \"Won 6 Oscars. Another 52 wins & 28 nominations.\",\n" +
            "\"Poster\":\n" +
            "\"https://m.media-amazon.com/images/M/MV5BNzVlY2MwMjktM2E4OS00Y2Y3LWE3ZjctYzhkZGM3YzA1ZWM2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg\",\n" +
            "\"Ratings\": [\n" +
            "{\n" +
            "\"Source\": \"Internet Movie Database\",\n" +
            "\"Value\": \"8.6/10\"\n" +
            "},\n" +
            "{\n" +
            "\"Source\": \"Rotten Tomatoes\",\n" +
            "\"Value\": \"92%\"\n" +
            "},\n" +
            "{\n" +
            "\"Source\": \"Metacritic\",\n" +
            "\"Value\": \"90/100\"\n" +
            "}\n" +
            "],\n" +
            "\"Metascore\": \"90\",\n" +
            "\"imdbRating\": \"8.6\",\n" +
            "\"imdbVotes\": \"1,181,083\",\n" +
            "\"imdbID\": \"tt0076759\",\n" +
            "\"Type\": \"movie\",\n" +
            "\"DVD\": \"21 Sep 2004\",\n" +
            "\"BoxOffice\": \"N/A\",\n" +
            "\"Production\": \"20th Century Fox\", \"Website\": \"N/A\",\n" +
            "\"Response\": \"True\"\n" +
            "}";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // movie 1, 2 ou 3
        String film = getIntent().getStringExtra("mon film");
        Log.d("Lol", "------->  " + film);

        //initialisation de la variable movie
        Movie movie1 = new Movie ("TOP GUN","17/09/1986","Action","bla blab nnhsfdgvdfdjk:b" +
                "vfjksnbvqjkbdfkbv<j<bdfk:bvjk<bdjfhjbdbvhdjbvdjfkvjbjf<d:vb:bdh<jbhj",
                "Tony Scott","Tom Cruise, Kelly McGillis, Tom Skerritt ","Oscar de la meilleure chanson");

        // Mise à jour de la vue après création du movie1
        mTitre = findViewById(R.id.text_view_titre);
        mDate = findViewById(R.id.text_view_date);
        mGenre = findViewById(R.id.text_view_genre);
        mPropos = findViewById(R.id.text_view_description);
        mDirector = findViewById(R.id.text_view_realisateur);
        mActor = findViewById(R.id.text_view_acteurs);
        mAward = findViewById(R.id.text_view_awards);


        Gson gson = new Gson();

        mMovie = gson.fromJson(strJSON, MovieJSON.class);

        updateUI(mMovie);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "J'aime", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void updateUI(MovieJSON pMovie) {

        mTitre.setText(pMovie.getTitle());
        mDate.setText(pMovie.getReleased());
        mGenre.setText(pMovie.getGenre());
        mPropos.setText(pMovie.getPlot());
        mDirector.setText(pMovie.getDirector());
        mActor.setText(pMovie.getActors());
        mAward.setText(pMovie.getAwards());

        Picasso.get().load(mMovie.getPoster()).fit().into((ImageView) findViewById(R.id.image_view_film));





    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onClickLirePlus(View view) {

        TextView lireplus = (TextView) view;

        if (((TextView) findViewById(R.id.text_view_description)).getMaxLines() == 3){
            (( TextView) findViewById(R.id.text_view_description)).setMaxLines(1000);
            lireplus.setText("");
        } else {
            (( TextView) findViewById(R.id.text_view_description)).setMaxLines(3);
            lireplus.setText("Lire la suite");
        }


    }
}
