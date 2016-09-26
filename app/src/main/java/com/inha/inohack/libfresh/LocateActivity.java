package com.inha.inohack.libfresh;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LocateActivity extends AppCompatActivity {
    private TextView txt1,txt2,lib_name;
    private ImageView img;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate);
        Intent intent=getIntent();
        int i = intent.getIntExtra("locate",0);
        //Toast.makeText(LocateActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
        txt1 = (TextView)findViewById(R.id.temp1);
        txt2 = (TextView)findViewById(R.id.temp2);
        lib_name = (TextView)findViewById(R.id.lib_name1);
        img = (ImageView)findViewById(R.id.imageView);

        LibItem item1;
        LibItem item2;
        if(i==1){
            img.setImageResource(R.drawable.high2);
            lib_name.setText("해동학술정보관");
            item1 = MainActivity.libItems.list.get(1);
            item2 =  MainActivity.libItems.list.get(10);
            txt1.setText(String.format("%.2f", item1.getTemperature()));
            txt2.setText(String.format("%.2f", item2.getTemperature()));
        }else if(i==2){
            img.setImageResource(R.drawable.high2);
            lib_name.setText("정석1열람실");
            item1 =  MainActivity.libItems.list.get(2);
            item2 =  MainActivity.libItems.list.get(11);
            txt1.setText(String.format("%.2f", item1.getTemperature()));
            txt2.setText(String.format("%.2f", item2.getTemperature()));

        }else if(i==3){
            img.setImageResource(R.drawable.high2);
            lib_name.setText("정석2열람실");
            item1 =  MainActivity.libItems.list.get(3);
            item2 =  MainActivity.libItems.list.get(12);
            txt1.setText(String.format("%.2f", item1.getTemperature()));
            txt2.setText(String.format("%.2f", item2.getTemperature()));

        }else if(i==4){
            img.setImageResource(R.drawable.high2);
            lib_name.setText("정석3열람실");
            item1 =  MainActivity.libItems.list.get(5);
            item2 =  MainActivity.libItems.list.get(13);
            txt1.setText(String.format("%.2f", item1.getTemperature()));
            txt2.setText(String.format("%.2f", item2.getTemperature()));

        }else{
            img.setImageResource(R.drawable.high2);
            lib_name.setText("하이테크공대도서관");
            item1 =  MainActivity.libItems.list.get(4);
            item2 =  MainActivity.libItems.list.get(9);
            txt1.setText(String.format("%.2f", item1.getTemperature()));
            txt2.setText(String.format("%.2f", item2.getTemperature()));
        }



    }
}
