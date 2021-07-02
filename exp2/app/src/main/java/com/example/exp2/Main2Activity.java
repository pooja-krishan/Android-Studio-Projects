package com.example.exp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    String n,r,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=findViewById(R.id.t1);
        tv2=findViewById(R.id.t2);
        tv3=findViewById(R.id.t3);

        Intent i = getIntent();
        n=i.getStringExtra("name");
        r=i.getStringExtra("roll");
        d=i.getStringExtra("dept");

        tv1.setText(n);
        tv2.setText(r);
        tv3.setText(d);
    }
}
