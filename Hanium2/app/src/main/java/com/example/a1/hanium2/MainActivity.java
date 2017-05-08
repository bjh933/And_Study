package com.example.a1.hanium2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import Model.Weather;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.textview);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            String strUrl = "";
            String strResponse = "";

            @Override
            public void onClick(View v)
            {

                AsyncTask asyncTask;
                asyncTask = new AsyncTask() {

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        //strUrl="http://10.0.2.2:8080";
                        strUrl="http://10.0.2.2:8080/weather?lat=10.1&lon=20.2";

                    }

                    @Override
                    protected Object doInBackground(Object[] params) {
                        URL url;
                        try {
                            url = new URL(strUrl);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");
                            InputStream is = conn.getInputStream();

                            StringBuilder builder = new StringBuilder();
                            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                            String line;
                            while ((line = br.readLine()) != null) {
                                builder.append(line);
                            }

                            strResponse = builder.toString();
                        }
                        catch (MalformedURLException e){
                            e.printStackTrace();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);
                        Weather weather = null;
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            weather = objectMapper.readValue(strResponse, Weather.class);
                        }
                        catch(IOException e) {
                            e.printStackTrace();

                        }

                        textview.setText(weather.getSkyStatus().toString() + " | " + weather.getWindDirection().toString() + " | " + weather.getRainAmount().toString());

                    }

                };
                asyncTask.execute();

            }
        });
    }
}
