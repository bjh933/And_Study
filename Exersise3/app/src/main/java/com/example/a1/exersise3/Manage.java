package com.example.a1.exersise3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by a1 on 2017. 4. 4..
 */

public class Manage extends AppCompatActivity{

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager);

        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);

        final String temp1 = btn1.getText().toString();
        final String temp2 = btn2.getText().toString();
        final String temp3 = btn3.getText().toString();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", temp1);
                setResult(0, resultIntent);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent resultIntent = new Intent();

                resultIntent.putExtra("name",temp2);

                setResult(1, resultIntent);

                finish();

            }

        });


        btn3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent resultIntent = new Intent();

                resultIntent.putExtra("name",temp3);

                setResult(2, resultIntent);

                finish();

            }

        });
    }

}
