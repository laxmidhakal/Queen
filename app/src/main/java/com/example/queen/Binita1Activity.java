package com.example.queen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Binita1Activity extends AppCompatActivity {
    Button okk;
    Button exit;
    Button tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binita1);
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
            Double vat=cursor.getDouble(3);
            Integer total=cursor.getInt(4);
            Integer txn=cursor.getInt(5);



            builder.append(" TXN NUMBER -"+txn+"\n \n"+"SENDER -" + name + "\n \n"+
                    "RECIEVER -" +description+"\n \n"+"AMOUNT - Rs."+price+"\n \n"+"VAT AMOUNT - Rs."+vat+"\n \n"+"TOTAL AMOUNT - Rs."+total);


        }
        while (cursor.moveToNext());
        final Button details=(Button) findViewById(R.id.details);

        details.setText(builder.toString());

        Button tran=(Button) findViewById(R.id.tran);
        tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d=new Intent(Binita1Activity.this,Binita2Activity.class);
                startActivity(d);
            }
        });
        Button exit=(Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dh=new Intent(Binita1Activity.this,Dash.class);
                startActivity(dh);
            }
        });

    }
}
