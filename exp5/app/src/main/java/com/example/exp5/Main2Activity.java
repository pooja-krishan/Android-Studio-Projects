package com.example.exp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=findViewById(R.id.text);
        Intent ni = getIntent();
        message=ni.getStringExtra("sendm");
        t.setText("Message received: "+message);
    }
}
