package com.example.queen;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dash extends AppCompatActivity {
    Button okk;
    Button laxmi;
    Button dhakal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        Button okk=(Button)findViewById(R.id.okk);
        Button laxmi=(Button) findViewById(R.id.laxmi);
        Button dhakal=(Button) findViewById(R.id.dhakal);
        dhakal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Dash.this,PendActivity.class);
                startActivity(i);

            }
        });

        laxmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Dash.this,R.style.CodingDemos);
                alertDialog.setTitle("CONFIRM");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Are you sure you want to make Payment?");
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Rs.1550 amount has been deducted from your account", Toast.LENGTH_SHORT).show();


                    }
                });
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent d=new Intent(Dash.this,MainActivity.class);
                        startActivity(d);

                    }
                });
                alertDialog.show();
            }
        });
        okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent la=new Intent(Dash.this,ThirdActivity.class);
                startActivity(la);
            }
        });
        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT NAME,PRICE,DESCRIPTION,VAT,TOTAL,TXN FROM PRODUCTS",new String[]{});
        if(cursor !=null){
            cursor.moveToFirst();

        }
        final StringBuilder builder=new StringBuilder();
        do{
            String name=cursor.getString(0);
            double price=cursor.getDouble(1);
            String description=cursor.getString(2);
            Integer vat=cursor.getInt(3);
            Integer total=cursor.getInt(4);
            Integer txn=cursor.getInt(5);



            builder.append(" TXN NUMBER -"+txn+"\n \n"+"SENDER -" + name + "\n \n"+
                    "RECIEVER -" +description+"\n \n"+"TOTAL AMOUNT -"+total+"\n \n"+"AMOUNT -"+price+"\n \n"+"VAT AMOUNT -"+vat+"\n \n");


        }
        while (cursor.moveToNext());
        final Button details=(Button) findViewById(R.id.details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.setText(builder.toString());
            }
        });
    }
}
