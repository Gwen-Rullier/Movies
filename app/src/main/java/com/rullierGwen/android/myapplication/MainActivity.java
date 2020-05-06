package com.rullierGwen.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewBonjour;
    private Button mButtonRechercher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //liaison à la vue
        mTextViewBonjour = findViewById(R.id.text_view_bonjour);
        mButtonRechercher = findViewById(R.id.buttonSearch);

        // changer le texte du titre
        mTextViewBonjour.setText(R.string.titre);
        //mTextViewBonjour.setText(R.string.titre);
        mTextViewBonjour.setTextColor(getResources().getColor(R.color.color_bleuTitre2));

        Toast.makeText(this, mTextViewBonjour.getText().toString(), Toast.LENGTH_SHORT).show();

        // le clic
        mButtonRechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Lol", "je viens de cliquer ");
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lol", "onDestroy : main activity ");
    }

    // clic sur linearLayout
    public void onClickLinearLayout(View view) {

        if (view.getId() == R.id.linearLayout_topGun){
            // Movie 1
            Toast.makeText(this,"Clic sur Top Gun" ,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MovieActivity.class);
            intent.putExtra("mon film", "Top Gun");
            startActivity(intent);
        } else {
            // Movie 2
            if (view.getId() == R.id.linearLayout_avatar){
                Toast.makeText(this,"Clic sur Avatar" ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MovieActivity.class);
                intent.putExtra("mon film", "Avatar");
                startActivity(intent);
            }else {
              //movie 3
                Toast.makeText(this,"Clic sur Intouchables" ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MovieActivity.class);
                intent.putExtra("mon film", "Intouchables");
                startActivity(intent);
            }

        }




    }


}
