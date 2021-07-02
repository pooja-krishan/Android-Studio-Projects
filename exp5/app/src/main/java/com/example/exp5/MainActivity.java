package com.example.exp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.exp5.channel_create.CHANNEL_ID;

public class MainActivity extends AppCompatActivity {
    EditText e;
    Button b;
    NotificationManagerCompat nmc;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.editText);
        nmc = NotificationManagerCompat.from(this);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmsg(v);
            }
        });
    }

    public void sendmsg(View view) {
        msg=e.getText().toString();
        Intent ni = new Intent(this,Main2Activity.class);
        ni.putExtra("sendm",msg);
        PendingIntent pi = PendingIntent.getActivity(this,0,ni,PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notify = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_textsms)
                .setContentTitle("New Message")
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();
        nmc.notify(1,notify);
    }
}
