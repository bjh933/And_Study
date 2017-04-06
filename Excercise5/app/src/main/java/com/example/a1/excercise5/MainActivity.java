package com.example.a1.excercise5;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.LinearLayout;

import android.widget.TextView;

import android.widget.Toast;


import java.text.SimpleDateFormat;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView year, month, day;
    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveBtn = (Button)findViewById(R.id.btn_save);
        final EditText name = (EditText)findViewById(R.id.ET_name);
        final EditText age = (EditText)findViewById(R.id.ET_age);

        year = (TextView)findViewById(R.id.mYear);
        month = (TextView)findViewById(R.id.mMonth);
        day = (TextView)findViewById(R.id.mDay);

        LinearLayout birth = (LinearLayout)findViewById(R.id.birth);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        temp = format.format(date);

        final String arr[] = temp.split("-");

        year.setText(arr[0]);
        month.setText(arr[1]);
        day.setText(arr[2]);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "\n이름 : "+name.getText().toString()+"\n나이 : "+age.getText().toString()+" \n생년월일 : "+temp,Toast.LENGTH_LONG).show();
            }
        });

        birth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sub.class);
                intent.putExtra("year", arr[0]);
                intent.putExtra("month", arr[1]);
                intent.putExtra("day", arr[2]);
                startActivityForResult(intent, 1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 0) {
            String temp2 = data.getExtras().getString("year");
            String temp3 = data.getExtras().getString("month");
            String temp4 = data.getExtras().getString("day");

            temp = temp2 + "년 " + temp3 + "월 " + temp4 + "일";

            year.setText(temp2);
            month.setText(temp3);
            day.setText(temp4);
        }

    }
}
