package com.inha.inohack.libfresh;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends FragmentActivity {

    private static String URL = "http://192.168.0.6:1212/loadListData";

    private ListView listView;
    private ListViewAdapter adapter;
    private ImageButton imageButton_left,imageButton_right;
    private TextView textTemperature,labelHumidity,textAirPollution;
    private Spinner spinner;
    private int locate_id=0;

    public static LibItems libItems;


    @Override
    protected void attachBaseContext(Context newBase) {
        // font 적용
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton_left = (ImageButton)findViewById(R.id.left);
        imageButton_right = (ImageButton)findViewById(R.id.right);
        textTemperature = (TextView)findViewById(R.id.textTemperature);
        labelHumidity = (TextView)findViewById(R.id.labelHumidity);
        textAirPollution = (TextView)findViewById(R.id.textAirPollution);


        spinner = (Spinner)findViewById(R.id.spinner1);
        List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.lib));
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<String>(this,R.layout.spinner_item,Lines);
        spinner.setAdapter(spinneradapter);

        //통신
        GetInitData getInitData = new GetInitData();
        getInitData.execute();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);
                locate_id=position;
                if(position !=0){
                    try {
                        LibItem item1;
                        LibItem item2;
                        if (locate_id==1){
                            item1 = libItems.list.get(1);
                            item2 = libItems.list.get(10);
                        }else if(locate_id==2){
                            item1 = libItems.list.get(2);
                            item2 = libItems.list.get(11);
                        }else if(locate_id==3){
                            item1 = libItems.list.get(3);
                            item2 = libItems.list.get(12);
                        }else if(locate_id==4){
                            item1 = libItems.list.get(5);
                            item2 = libItems.list.get(13);
                        }else{
                            item1 = libItems.list.get(4);
                            item2 = libItems.list.get(9);
                        }
                        textTemperature.setText(String.valueOf(String.format("%.2f", (item1.getTemperature()+item2.getTemperature())/2)));
                        labelHumidity.setText(String.valueOf((item1.getHumidity()+item2.getHumidity())/2));
                        textAirPollution.setText(item1.getAirPollution());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                locate_id=0;
            }
        });



        imageButton_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LocateActivity.class);
                intent.putExtra("locate",locate_id);
                startActivity(intent);

            }
        });
        imageButton_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ChartActivity.class);
                startActivity(intent);

            }
        });

    }




    private class GetInitData extends AsyncTask<String, Void, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder().add("a","").build();
                Request request = new Request.Builder().url(URL).post(requestBody).build();
                Response response = okHttpClient.newCall(request).execute();
                Log.d("MainActivity__","test");
                String str = response.body().string();

                Log.d("MainActivity__",str);
                return str;

            }catch (Exception e){
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String temp) {
            Log.d("JSONDATA",temp);
            try {
                libItems = new LibItems();
                libItems.list = new ArrayList<LibItem>();
                LibItem item;
                JSONArray jarray = new JSONArray(temp);
                for ( int i =0; i < jarray.length();i++)
                {
                    JSONObject j = jarray.getJSONObject(i);
                    item = new LibItem(Integer.parseInt(j.getString("no")),j.getString("name"), j.getString("date"),
                            j.getString("time"),Double.parseDouble(j.getString("temperature")),Integer.parseInt(j.getString("humidity")),
                            Integer.parseInt(j.getString("air_pollution")));
                    libItems.list.add(item);

                    Log.d("JSON", j.getString("no") + " " + j.getString("name") + " "+ j.getString("date") + " "
                    + j.getString("time") + " "+ j.getString("temperature") + " "+ j.getString("humidity")+ " "+ j.getString("air_pollution"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                LibItem item1;
                LibItem item2;
                if (locate_id==1){
                    item1 = libItems.list.get(1);
                    item2 = libItems.list.get(10);
                }else if(locate_id==2){
                    item1 = libItems.list.get(2);
                    item2 = libItems.list.get(11);
                }else if(locate_id==3){
                    item1 = libItems.list.get(3);
                    item2 = libItems.list.get(12);
                }else if(locate_id==4){
                    item1 = libItems.list.get(5);
                    item2 = libItems.list.get(13);
                }else{
                    item1 = libItems.list.get(4);
                    item2 = libItems.list.get(9);
                }
                textTemperature.setText(String.valueOf(String.format("%.2f", (item1.getTemperature()+item2.getTemperature())/2)));
                labelHumidity.setText(String.valueOf((item1.getHumidity()+item2.getHumidity())/2));
                textAirPollution.setText(item1.getAirPollution());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    public class LibItems{
        public List<LibItem> list;


    }
}
