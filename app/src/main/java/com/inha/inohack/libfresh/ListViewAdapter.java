package com.inha.inohack.libfresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 2016-09-23.
 */
public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<LibItem> listViewItemList = new ArrayList<LibItem>();

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        ViewHolder viewHolder;

        // 리스트가 길어지면서 현재 화면에 보이지 않는 아이템은 converView가 null인 상태로 들어 옴
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lib_listview_item_grid, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.libName = (TextView) convertView.findViewById(R.id.lib_name);
            viewHolder.textTemp = (TextView) convertView.findViewById(R.id.textTemprature);
            viewHolder.textHum = (TextView) convertView.findViewById(R.id.textHumidity);
            viewHolder.textAirPol = (TextView) convertView.findViewById(R.id.textAirPollution);
//            ImageView imageTemp;
//            ImageView imageHum;
//            ImageView imageAirPol;

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        LibItem libItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        viewHolder.libName.setText(libItem.getName());
        //viewHolder.dateTime.setText(libItem.getDate()+ " "+libItem.getTime() + " 현재");


        return convertView;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(int no, String name, String date, String time, double temperature, int humidity, int airPollution) {

        LibItem libItem = new LibItem(no,name, date, time, temperature, humidity, airPollution);
        listViewItemList.add(libItem);

    }

    private static class ViewHolder {
        TextView libName;
        TextView dateTime;

        TextView textTemp;
        TextView textHum;
        TextView textAirPol;

        ImageView imageTemp;
        ImageView imageHum;
        ImageView imageAirPol;
    }
}