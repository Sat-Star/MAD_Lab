package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,BPlus,BEqual,BMul,BMinus,BDiv,BClr;
    EditText Et_result;
    float v1,v2;
    boolean add=false,sub=false,mul=false,div=false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b0=(Button)findViewById(R.id.b0);
        BEqual=(Button)findViewById(R.id.beq);
        BPlus=(Button)findViewById(R.id.bplus);
        BMinus=(Button)findViewById(R.id.bminus);
        BDiv=(Button)findViewById(R.id.bdiv);
        BMul=(Button)findViewById(R.id.bmul);
        BClr = (Button)findViewById(R.id.bclr);
        Et_result=(EditText)findViewById(R.id.result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et_result.setText(Et_result.getText()+"0");
            }
        });
        BPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1=Float.parseFloat(Et_result.getText()+"");
                add=true;
                Et_result.setText(null);
            }
        });
        BMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1=Float.parseFloat(Et_result.getText()+"");
                Et_result.setText(null);
                sub=true;
            }
        });
        BMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1=Float.parseFloat(Et_result.getText()+"");
                Et_result.setText(null);
                mul=true;
            }
        });
        BDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1=Float.parseFloat(Et_result.getText()+"");
                Et_result.setText(null);
                div=true;
            }
        });
        BEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v2=Float.parseFloat(String.valueOf(Et_result.getText()));
                if(add)
                {
                    Et_result.setText(v1+v2+"");
                    add=false;
                }
                if(sub)
                {
                    Et_result.setText(v1-v2+"");
                    sub=false;
                }
                if(mul)
                {
                    Et_result.setText(v1*v2+"");
                    mul=false;
                }
                if(div)
                {
                    Et_result.setText(v1/v2+"");
                    div=false;
                }

            }
        });

        BClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Et_result.setText(null);
            }
        });

    }
}
