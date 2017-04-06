package com.example.a1.exercise4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by a1 on 2017. 4. 4..
 */

public class Sub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);


        Intent get = getIntent();

        String temp = get.getExtras().getString("name");

        Button btn = (Button) findViewById(R.id.closeBtn);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(temp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(getApplicationContext(), Manage.class);
                startActivity(resultIntent);
                finish();

            }
        });
    }
}
