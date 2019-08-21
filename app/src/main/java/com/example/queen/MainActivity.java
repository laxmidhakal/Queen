package com.example.queen;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    NotificationCompat.Builder mBuilder;
    PendingIntent mResultPendingIntent;
    TaskStackBuilder mTaskStackBuilder;
    Intent mResultIntent;
    NotificationManager mNotificationManager;
    Button admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button forth=(Button) findViewById(R.id.forth);
        Button dhakal=(Button) findViewById(R.id.dhakall);
        Button admin=(Button) findViewById(R.id.admin);
       // mBuilder=new NotificationCompat.Builder(this);
       /* mBuilder.setSmallIcon(R.drawable.laxmi);
        mBuilder.setContentTitle("Notification title");
        mBuilder.setContentText("Notification detail");
        mResultIntent=new Intent(this,DhakalActivity.class);
        mTaskStackBuilder=TaskStackBuilder.create(this);
        mTaskStackBuilder.addParentStack(MainActivity.this);
        mTaskStackBuilder.addNextIntent(mResultIntent);
        mResultPendingIntent=mTaskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(mResultPendingIntent);
        mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);*/
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mNotificationManager.notify(1,mBuilder.build());
                Intent o=new Intent(MainActivity.this,FrontActivity.class);
                startActivity(o);

            }
        });
        dhakal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(MainActivity.this,FourthActivity.class);
                startActivity(o);
            }
        });
        forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mNotificationManager.notify(1,mBuilder.build());
                Intent a=new Intent(MainActivity.this,BinitaActivity.class);
               startActivity(a);
            }
        });
        Spinner colouredSpinner=(Spinner)findViewById(R.id.coloredSpinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,
                R.array.Spinner_Items,
                R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        colouredSpinner.setAdapter(adapter);
        colouredSpinner.setOnItemSelectedListener(this);


       /* MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT NAME,PRICE,DESCRIPTION FROM PRODUCTS",new String[]{});
        if(cursor !=null){
            cursor.moveToFirst();

        }
        final StringBuilder builder=new StringBuilder();
        do{
            String name=cursor.getString(0);
            double price=cursor.getDouble(1);
            String description=cursor.getString(2);


            builder.append("SENDER -" + name + "\n \n"+"RECIEVER -" +description+"\n \n"+"TOTAL AMOUNT -"+price+"\n");


        }
        while (cursor.moveToNext());
        final Button button=(Button) findViewById(R.id.button);
        final TextView click=(TextView) findViewById(R.id.click);
        button.setText(builder.toString());
        */



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.help:
                Intent i1=new Intent(this,Help.class);
                this.startActivity( i1);
                return true;
            case R.id.about:

                Intent i2=new Intent(this,Dash.class);
                this.startActivity( i2);
                return true;
                default:
            return super.onOptionsItemSelected(item);

        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getItemAtPosition(position).equals("laxmi")){

        }
        else {
            //String text=parent.getItemAtPosition(position).toString();
            //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
            MyHelpe helper=new MyHelpe(this);
            SQLiteDatabase database=helper.getReadableDatabase();
            Cursor cursor=database.rawQuery("SELECT NAME,PRICE,DESCRIPTION FROM MAMTA ",new String[]{});
            if(cursor !=null){
                cursor.moveToFirst();

            }
            final StringBuilder builder=new StringBuilder();
            do{
                String name=cursor.getString(0);
                double price=cursor.getDouble(1);
                String description=cursor.getString(2);


                builder.append("SENDER -" + name + "\n \n"+"RECIEVER -" +description+"\n \n"+"TOTAL AMOUNT -"+price+"\n");


            }
            while (cursor.moveToNext());
            final Button button=(Button) findViewById(R.id.button);
            final TextView click=(TextView) findViewById(R.id.click);
            button.setText(builder.toString());
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
