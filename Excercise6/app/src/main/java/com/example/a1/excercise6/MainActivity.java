package com.example.a1.exercise6;

import android.os.Handler;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static com.example.a1.exercise6.R.id.btn1;
import static com.example.a1.exercise6.R.id.et_url;

public class MainActivity extends AppCompatActivity {

    private WebView webview;
    private Handler mHandler = new Handler();

    boolean isPageOpen = false;

    Animation translateDownAnim;
    Animation translateUpAnim;
    LinearLayout slidingPage01;
    Button btn1;
    Button go;
    EditText et_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_url = (EditText)findViewById(R.id.et_url);
        btn1 = (Button)findViewById(R.id.btn1);
        slidingPage01 = (LinearLayout)findViewById(R.id.slidingPage01);
        translateDownAnim = AnimationUtils.loadAnimation(this, R.anim.translate_down);
        translateUpAnim = AnimationUtils.loadAnimation(this,R.anim.translate_up);

        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();
        translateDownAnim.setAnimationListener(animListener);
        translateUpAnim.setAnimationListener(animListener);


        go = (Button)findViewById(R.id.go);
        webview = (WebView) findViewById(R.id.webview);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.setWebViewClient(new WebViewClient());
                slidingPage01.startAnimation(translateUpAnim);
                webview.loadUrl("http://" + et_url.getText().toString());
            }
        });
    }

    public void onButton1Clicked(View v) {
        if (isPageOpen){
            slidingPage01.startAnimation(translateUpAnim);
        } else {
            slidingPage01.setVisibility(View.VISIBLE);
            slidingPage01.startAnimation(translateDownAnim);
        }
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                slidingPage01.setVisibility(View.INVISIBLE);
                btn1.setText("주소창 보기");
                isPageOpen = false;
            } else {
                btn1.setText("올리기");
                isPageOpen = true;
            }
        }

        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationStart(Animation animation) {

        }

    }

}

