package com.example.a1.recyclerview_newact;

        import android.content.SharedPreferences;
        import android.os.Parcelable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    LinearLayoutManager llm;
    List<String> count = null;
    Button btn;
    EditText et = null;
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.et);
        rv = (RecyclerView)findViewById(R.id.rv);
        btn = (Button)findViewById(R.id.btn);
        llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);

        count = new ArrayList<>();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                text = et.getText().toString();
                count.add(text);
                rv.setAdapter(new CountAdapter(getApplication(), count, text));

            }

        });

    }



}
