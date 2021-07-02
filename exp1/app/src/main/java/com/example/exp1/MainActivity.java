package com.example.exp1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int fsize=20;
    int ch=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView t = findViewById(R.id.name);
        Button button1 = findViewById(R.id.b1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setTextSize(fsize);
                fsize=fsize+2;
                if(fsize==40)
                    fsize=20;
            }
        });
        Button button2 = findViewById(R.id.b2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(ch) {
                    case 1:
                        t.setTextColor(Color.RED);
                        break;
                    case 2:
                        t.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        t.setTextColor(Color.BLUE);
                        break;
                    case 4:
                        t.setTextColor(Color.CYAN);
                        break;
                    case 5:
                        t.setTextColor(Color.MAGENTA);
                        break;
                    case 6:
                        t.setTextColor(Color.YELLOW);
                        break;
                    case 7:
                        t.setTextColor(Color.BLACK);
                        break;
                }
                ch++;
                if(ch==8)
                    ch=1;
            }
        });
    }
}
