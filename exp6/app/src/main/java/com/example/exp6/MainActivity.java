package com.example.exp6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Handler hand = new Handler();
    Button click;
    TextView timer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView) findViewById(R.id.timer);
        click = (Button) findViewById(R.id.clickme);
        hand.postDelayed(run, 1000);
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            updateTime();
        }
    };

    @SuppressLint("WrongConstant")
    public void updateTime() {
        timer.setText(""+(Integer.parseInt(timer.getText().toString()) - 1));
        if (Integer.parseInt(timer.getText().toString()) == 0) {
            click.setVisibility(0);
        } else {
            hand.postDelayed(run, 1000);
        }
    }
}
