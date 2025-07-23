package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, reset;
    TextView result, player1, player2;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    String name1, name2;
    boolean gameOver=false;
    int flag = 0;
    int moves = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting player names
        Intent names = getIntent();
        name1 = names.getStringExtra("Play1");
        name2 = names.getStringExtra("Play2");

        // Finding Views
        player1 = findViewById(R.id.setPlayer1);
        player2 = findViewById(R.id.setPlayer2);
        result = findViewById(R.id.result);
        reset = findViewById(R.id.reset);

        player1.setText("X " + name1);
        player2.setText("O " + name2);

        initButtons();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEmpty();
            }
        });
    }

    public void initButtons() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check(View v) {
        if(gameOver) return;
        Button btnClick = (Button) v;

        if (btnClick.getText().toString().equals("")) {
            moves++;

            if (flag == 0) {
                btnClick.setText("X");
                flag = 1;
            } else {
                btnClick.setText("O");
                flag = 0;
            }

            if (moves > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    declareWinner(b1); return;
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    declareWinner(b4); return;
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    declareWinner(b7); return;
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    declareWinner(b1); return;
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    declareWinner(b2); return;
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    declareWinner(b3); return;
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    declareWinner(b1); return;
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    declareWinner(b3); return;
                } else if (moves == 9) {
                    result.setText("IT'S A DRAW");
                }
            }
        }
    }

    public void declareWinner(String symbol) {
        if (symbol.equals("X")) {
            result.setText("WINNER IS " + name1);
        } else {
            result.setText("WINNER IS " + name2);
        }
        gameOver=true;
    }

    public void setEmpty() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        result.setText("");
        flag = 0;
        gameOver=false;
        moves = 0;
    }
}
