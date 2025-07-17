package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Player_Names extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);

        Button btn;
        EditText player1Name,player2Name;

        btn=findViewById(R.id.start);
        player1Name=findViewById(R.id.player1);
        player2Name=findViewById(R.id.player2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=player1Name.getText().toString();
                String name2=player2Name.getText().toString();
                Intent play=new Intent(Player_Names.this,MainActivity.class);
                play.putExtra("play1",name1);
                play.putExtra("play2",name2);
                startActivity(play);
            }
        });
    }
}