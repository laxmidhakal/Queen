package com.example.queen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PanActivity extends AppCompatActivity {
    Button pan;
    Button pan1;
    Button de;
    Button ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan);
        Button pan=(Button) findViewById(R.id.pan);
        Button de=(Button) findViewById(R.id.de);
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button pan1=(Button) findViewById(R.id.pan1);
        Button ok=(Button) findViewById(R.id.ok);
    }
}
