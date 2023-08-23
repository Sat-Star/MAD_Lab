package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,beq,minus,div,clr,mul;
    EditText res;
    Float v1,v2;
    Boolean add,sub,bmulm,bdiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        b0 = (Button)findViewById(R.id.b0);
        plus = (Button)findViewById(R.id.bplus);
        minus = (Button)findViewById(R.id.bminus);
        div = (Button)findViewById(R.id.bdiv);
        beq = (Button)findViewById(R.id.beq);
        clr = (Button)findViewById(R.id.bclr);

        res = (EditText) findViewById(R.id.result);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                res.setText(res.getText()+"0");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(res.getText()+"");
                add = true;
                res.setText(null);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(res.getText()+"");
                sub = true;
                res.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(res.getText()+"");
                bmulm = true;
                res.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(res.getText()+"");
                bdiv = true;
                res.setText(null);
            }
        });

        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v2 = Float.parseFloat(String.valueOf(res.getText()));
                if(add){
                    res.setText(v1+v2+"");
                    add = false;
                }
                if(sub){
                    res.setText(v1-v2+"");
                    sub = false;
                }
                if(bmulm){
                    res.setText(v1*v2+"");
                    bmulm = false;
                }
                if(bdiv){
                    res.setText(v1/v2+"");
                    bdiv = false;
                }
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText(null);
            }
        });


    }
}
