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
import android.widget.ImageButton;
import android.widget.ImageView;

public class HistoryActivity extends AppCompatActivity {
    ImageView binita;
    ImageView lax;
    ImageView mam;
    Button lux;
    Button mama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ImageView lax=(ImageView) findViewById(R.id.lax);
        ImageView mam=(ImageView) findViewById(R.id.mam);
        ImageView binita=(ImageView) findViewById(R.id.binita);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.binita);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        binita.setImageDrawable(roundedBitmapDrawable);
        Bitmap bitma= BitmapFactory.decodeResource(getResources(),R.drawable.laxmi);
        RoundedBitmapDrawable rounded= RoundedBitmapDrawableFactory.create(getResources(),bitma);
        rounded.setCircular(true);
        lax.setImageDrawable(rounded);
        Bitmap bit= BitmapFactory.decodeResource(getResources(),R.drawable.mamta);
        RoundedBitmapDrawable roundedBitmap= RoundedBitmapDrawableFactory.create(getResources(),bit);
        roundedBitmap.setCircular(true);
        mam.setImageDrawable(roundedBitmap);



    }
}
