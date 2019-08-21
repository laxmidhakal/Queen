package com.example.queen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrontActivity extends AppCompatActivity {

    EditText etpass;
    EditText etuser;
    Button de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        etpass=(EditText) findViewById(R.id.etpass);
        etuser=(EditText) findViewById(R.id.etuser);
        Button de=(Button) findViewById(R.id.de);
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();

            }
        });
    }
    public void Check(){
        if ( etuser.getText().toString().equals("binita") && etpass.getText().toString().equals("binita niroula")){

            //Intent a=new Intent(FrontActivity.this,AdminActivity.class);
           // startActivity(a);
            MyHelper helper=new MyHelper(this);
            SQLiteDatabase database=helper.getReadableDatabase();
            Cursor cursor=database.rawQuery("SELECT NAME,PRICE,DESCRIPTION FROM PRODUCTS ",new String[]{});
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
            final Button ok=(Button) findViewById(R.id.button);
            //final TextView click=(TextView) findViewById(R.id.click);
            ok.setText(builder.toString());

        }
        if(etuser.getText().toString().equals("mamta") && etpass.getText().toString().equals("mamta")) {
            MyHelp helper=new MyHelp(this);
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
            final Button ok=(Button) findViewById(R.id.button);
            //final TextView click=(TextView) findViewById(R.id.click);
            ok.setText(builder.toString());
            //Toast.makeText(this,"Please enter the correct value",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"Please enter the correct value",Toast.LENGTH_SHORT).show();

        }
    }
}
