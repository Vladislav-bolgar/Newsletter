package com.example.newsletter.data.model;

import android.app.Activity;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

import com.example.newsletter.R;

public class PushNotificationManager {

    Activity context;



    public PushNotificationManager(Activity context){
        this.context = context;
    }


    public void CreateNotificationChannel(String Title, String Message) {

        android.app.NotificationManager notificationManager =
                (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("nl1000", "My channel",
                    android.app.NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("My channel description");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context, "nl1000")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(Title)
                            .setContentText(Message);

            notificationManager.notify(1, builder.build());
        }

    }

}
