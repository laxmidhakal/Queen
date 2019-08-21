package com.example.queen;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.queen.App.CHANNEL_1_ID;


public class FourthActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    TextView text;
    EditText etpass;
    EditText etuser;
    Button con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        notificationManager= NotificationManagerCompat.from(this);
        TextView text=(TextView) findViewById(R.id.text);


        etpass=(EditText) findViewById(R.id.etpass);
        etuser=(EditText) findViewById(R.id.etuser);
        Button con=(Button) findViewById(R.id.con);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();

            }
        });
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
    public void Check(){
        if ( etuser.getText().toString().equals("admin") && etpass.getText().toString().equals("admin")){

            Intent a=new Intent(FourthActivity.this,AdminActivity.class);
            startActivity(a);

        }
        else if ( etuser.getText().toString().equals("laxmi") && etpass.getText().toString().equals("admin")){

            Intent a=new Intent(FourthActivity.this,MainActivity.class);
            startActivity(a);

        }

        else {
            Toast.makeText(this,"Please enter the correct value",Toast.LENGTH_SHORT).show();

        }
    }
}
