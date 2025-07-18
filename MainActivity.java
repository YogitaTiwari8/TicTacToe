package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,reset;
    TextView result;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9,name1,name2;


    int flag=0;
    int moves=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent names=getIntent();
        name1=names.getStringExtra("play1");
        name2=names.getStringExtra("play2");
        init();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEmpty();
            }
        });

    }
    public void init(){
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        reset=findViewById(R.id.reset);
        result=findViewById(R.id.result);

    }

    public void check(View v){
        Button btnclick=(Button) v;
        if(btnclick.getText().toString().equals("")){
            moves++;

            if (flag == 0) {
                btnclick.setText(name2);
                flag = 1;
            } else {
                btnclick.setText(name1);
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
                    result.setText("WINNER IS "+b1);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    result.setText("WINNER IS "+b4);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    result.setText("WINNER IS "+b7);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    result.setText("WINNER IS "+b1);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    result.setText("WINNER IS "+b2);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    result.setText("WINNER IS "+b3);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    result.setText("WINNER IS "+b1);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    result.setText("WINNER IS "+b3);
                } else if(moves==9){
                    result.setText("IT'S A DRAW");
                }
            }
        }
    }
    public void setEmpty(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        moves=0;
        flag=0;
    }

}