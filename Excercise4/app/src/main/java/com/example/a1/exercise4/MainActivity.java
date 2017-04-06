package com.example.a1.exercise4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ANOTHER = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.idText);
        final EditText editText2 = (EditText) findViewById(R.id.pass);

        Button btn = (Button)findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String test = editText.getText().toString();

                final String test2 = editText2.getText().toString();

                if(test == null || test == "" || test.length() <= 0){
                    Toast.makeText(getApplicationContext(), "아이디를 입력하시오", Toast.LENGTH_LONG).show();
                }

                else if(test2 == null || test2 == "" || test2.length() <= 0){
                    Toast.makeText(getApplicationContext(), "패스워드를 입력하시오", Toast.LENGTH_LONG).show();
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), Manage.class);
                    startActivityForResult(intent, REQUEST_CODE_ANOTHER);
                    finish();
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 0) {
            String temp = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(), temp+", 요청코드 : "+requestCode+" 결과코드 : "+resultCode,Toast.LENGTH_LONG).show();

        }

        else if(resultCode == 1) {
            String temp = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(), temp+", 요청코드 : "+requestCode+" 결과코드 : "+resultCode,Toast.LENGTH_LONG).show();

        }

        else if(resultCode == 2) {
            String temp = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(), temp+", 요청코드 : "+requestCode+" 결과코드 : "+resultCode,Toast.LENGTH_LONG).show();

        }
    }
}
