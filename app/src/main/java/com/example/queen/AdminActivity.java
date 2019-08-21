package com.example.queen;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.os.Build.VERSION_CODES.N;
import static com.example.queen.App.CHANNEL_1_ID;
//import static com.example.queen.App.CHANNEL_2_ID;

public class AdminActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;


    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        notificationManager=NotificationManagerCompat.from(this);
        editTextTitle=findViewById(R.id.edit_text_title);
        editTextMessage=findViewById(R.id.edit_text_message);


    }
    public void sendOnChannel1(View v){

        Intent axtivityIntent=new Intent(this,DhakalActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,
                0,axtivityIntent,0);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("NOTIFICATION")
                .setContentText("Check your account ")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .build();
        notificationManager.notify(1,notification);

    }
   /* public void sendOnChannel2(View v)
    {
        String title=editTextTitle.getText().toString();
        String message=editTextMessage.getText().toString();
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)

                .build();
        notificationManager.notify(2,notification);

    }*/
}
