package com.example.a1.exercise4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by a1 on 2017. 4. 4..
 */

public class Manage extends AppCompatActivity {

    int code = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button login = (Button)findViewById(R.id.login2);

        final String temp1 = btn1.getText().toString();

        final String temp2 = btn2.getText().toString();

        final String temp3 = btn3.getText().toString();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent(getApplicationContext(), Sub.class);
                resultIntent.putExtra("name", temp1);
                startActivity(resultIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent(getApplicationContext(), Sub.class);
                resultIntent.putExtra("name", temp2);
                startActivity(resultIntent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent(getApplicationContext(), Sub.class);
                resultIntent.putExtra("name", temp3);
                startActivity(resultIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(resultIntent);
                finish();
            }
        });
    }
}
