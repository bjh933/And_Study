package com.example.a1.exercise2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btn1, btn2;
    String str;
    TextWatcher watcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.eText);
        textView = (TextView) findViewById(R.id.tv);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                str = s.toString();
                int len = str.length();
                textView.setText(len + " / "+ "80 "+"바이트");
                if(len > 80)
                {

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }


        };
        editText.addTextChangedListener(watcher);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            }
        });

    }
}
