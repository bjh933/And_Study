package com.example.a1.exersise3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ANOTHER = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Manage.class);
                startActivityForResult(intent, REQUEST_CODE_ANOTHER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 0){
            String temp = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(), temp+", 요청코드 : "+requestCode+" 결과코드 : "+resultCode,Toast.LENGTH_LONG).show();

        } else if (resultCode == 1){

            String temp = data.getExtras().getString("name");

            Toast.makeText(getApplicationContext(), temp+", 요청코드 : "+requestCode+" 결과코드 : "+resultCode,Toast.LENGTH_LONG).show();

        } else if (resultCode == 2){

            String temp = data.getExtras().getString("name");

            Toast.makeText(getApplicationContext(), temp+", 요청코드 : "+requestCode+" " +
                    "결과코드 : "+resultCode,Toast.LENGTH_LONG).show();

        }
    }
}



