package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class player_names extends AppCompatActivity {
    EditText player1,player2;
    TextView validate;
    String name1,name2;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);

        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        start=findViewById(R.id.start);
        validate=findViewById(R.id.validate);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1=player1.getText().toString();
                name2=player2.getText().toString();
                if(name1.equals("") || name2.equals("")){
                    validate.setText("Field is Empty");
                }
                else {
                    Intent play = new Intent(player_names.this, MainActivity.class);
                    play.putExtra("Play1", name1);
                    play.putExtra("Play2", name2);
                    startActivity(play);
                }
            }
        });




    }
}