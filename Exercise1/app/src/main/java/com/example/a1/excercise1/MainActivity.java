package com.example.a1.excercise1;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView1, scrollView2;
    ImageView imageView1, imageView2;
    BitmapDrawable bitmap;

    private Button btn1, btn2;
    private View.OnClickListener mlistener;
    public boolean switch1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageview1);
        imageView2 = (ImageView) findViewById(R.id.imageview2);

        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);

        mlistener = new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(v==btn2 && !switch1){
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);

                    switch1 = true;
            }
            else if(v==btn1 && switch1){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);

                    switch1 = false;
                }
            }
        };

        btn1.setOnClickListener(mlistener);
        btn2.setOnClickListener(mlistener);

    }

}
