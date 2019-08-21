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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    TextView text;
    EditText etpass;
    Button con;
    Button can;
    ImageView binita;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView binita=(ImageView) findViewById(R.id.binita);
        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT NAME FROM PRODUCTS",new String[]{});
        if(cursor !=null){
            cursor.moveToFirst();

        }
        final StringBuilder builder=new StringBuilder();
        do{
            String name=cursor.getString(0);
             //Integer amount=cursor.getInt(1);



            builder.append(" ACCOUNT HOLDER -" + name + "\n \n"
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
        TextView text=(TextView) findViewById(R.id.text);


        Button can=(Button) findViewById(R.id.can);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(a);
            }
        });

        etpass=(EditText) findViewById(R.id.etpass);
        Button con=(Button) findViewById(R.id.con);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();

            }
        });

    }
    public void Check(){
        if ( etpass.getText().toString().equals("1550")){
            //Toast.makeText(this,"pass",Toast.LENGTH_SHORT).show();
            Intent a=new Intent(ThirdActivity.this,MainActivity.class);
            startActivity(a);

        }
        else {
            Toast.makeText(this,"please Enter the Correct amount",Toast.LENGTH_SHORT).show();

        }
    }
}







