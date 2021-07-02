package com.example.exp5;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class channel_create extends Application {
    public static final String CHANNEL_ID = "channelid";
    @Override
    public void onCreate() {
        super.onCreate();
        channel();
    }

    private void channel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel ch = new NotificationChannel(
                    CHANNEL_ID,
                    "Message notification",
                    NotificationManager.IMPORTANCE_DEFAULT);
            ch.setDescription("This notification is used to notify the user the receipt of a message");
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(ch);
        }
    }
}
