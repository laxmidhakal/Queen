package com.example.queen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BinitaActivity extends AppCompatActivity {
    //ImageView binita;
    Button binita;
    Button bini;
    Button ok;
    Button mamta;
    Button mam;
    Button okk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binita);
        Button binita=(Button) findViewById(R.id.binita);
        Button ok=(Button) findViewById(R.id.ok);
       /* ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(BinitaActivity.this,Dash.class);
                startActivity(a);
            }
        });*/
        Button okk=(Button) findViewById(R.id.okk);
        okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(BinitaActivity.this,Mamta1Activity.class);
                startActivity(a);
            }
        });
        Button mamta=(Button) findViewById(R.id.mamta);

        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT NAME,DESCRIPTION,PRICE,TXN FROM PRODUCTS",new String[]{});
        if(cursor !=null){
            cursor.moveToFirst();

        }
        final StringBuilder builder=new StringBuilder();
        do{
            String name=cursor.getString(0);
            String description=cursor.getString(1);
            //Integer total=cursor.getInt(2);
            //Integer vat=cursor.getInt(3);
            Integer txn=cursor.getInt(2);
            Double price=cursor.getDouble(3);
            //Integer amount=cursor.getInt(1);



            builder.append(" TXN NUMBER -" + txn + "\n \n"+"Sender-"+name+"\n \n"+"Reciever-"+description+"\n \n"+"total amount-"+price+"\n \n"

            );


        }
        while (cursor.moveToNext());
        final Button bini=(Button) findViewById(R.id.bini);
        binita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bini.setText(builder.toString());


            }
        });

        /*MyHelp helpe=new MyHelp(this);
        SQLiteDatabase databas=helpe.getReadableDatabase();
        Cursor curso=databas.rawQuery("SELECT NAME,DESCRIPTION FROM MAMTA",new String[]{});
        if(curso !=null){
            curso.moveToFirst();

        }
        final StringBuilder builde=new StringBuilder();
        do{
            String name=curso.getString(0);
            String description=curso.getString(1);
            Integer total=curso.getInt(2);
            Double price=curso.getDouble(3);
//            Integer vat=cursor.getInt(4);
           // Integer txn=cursor.getInt(5);
            //Integer amount=cursor.getInt(1);



            builde.append( "Sender-"+name+"\n \n"+"Reciever-"+description+"\n \n"+"total amount-"+total+"\n \n"
                    +"\n \n"+"price-"+price+"\n \n"
            );


        }
        while (curso.moveToNext());
        final Button mam=(Button) findViewById(R.id.mam);
        mamta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mam.setText(builde.toString());


            }
        });*/

    }
}
