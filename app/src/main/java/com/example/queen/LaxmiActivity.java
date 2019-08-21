package com.example.queen;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LaxmiActivity extends AppCompatActivity {
    ImageView binita;
    Button bini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laxmi);
        ImageView binita=(ImageView) findViewById(R.id.binita);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.binita);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        binita.setImageDrawable(roundedBitmapDrawable);
         //final CardView bini=(CardView) findViewById(R.id.bini);
        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("TOTAL",400);
        database.update("PRODUCTS",values,"_id = ?",new String[]{"1"});
        Cursor cursor=database.rawQuery("SELECT NAME,RUPI,TOTAL FROM PRODUCTS",new String[]{});
        if(cursor !=null){
            cursor.moveToFirst();

        }
        final StringBuilder builder=new StringBuilder();
        do{
            String name=cursor.getString(0);
            Integer amount=cursor.getInt(1);
            Integer total=cursor.getInt(2);



            builder.append(" ACCOUNT HOLDER -" + name + "\n \n"+"AMOUNT-RS." +amount+"\n \n"+"CURRENT AMOUNT-"+total
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
    }
}
