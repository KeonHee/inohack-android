package com.inha.inohack.libfresh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;




import java.util.ArrayList;
import java.util.Random;


/**
 * Created by user on 2016-09-24.
 */
public class WeekChartFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_week, container, false);



        BarChart chart1 = (BarChart)rootView.findViewById(R.id.chart1);
        BarChart chart2 = (BarChart)rootView.findViewById(R.id.chart2);
        BarChart chart3 = (BarChart)rootView.findViewById(R.id.chart3);
        BarData data1 = new BarData(getXAxisValues(), getDataSet1());

        chart1.setData(data1);
        chart1.setDescription("");
        chart1.setDescriptionTextSize(20);
        chart1.animateXY(2000, 2000);
        chart1.invalidate();
        chart2.setBackgroundColor(Color.rgb(16,23,76));
        chart1.setDrawingCacheBackgroundColor(Color.rgb(0,0,0));
        chart1.getXAxis().setDrawGridLines(false);
        chart1.getAxisLeft().setDrawGridLines(false);
        chart1.getAxisRight().setDrawGridLines(false);
        chart1.setGridBackgroundColor(Color.rgb(16,23,76));
        XAxis xAxis1 = chart1.getXAxis();
        xAxis1.setTextColor(Color.rgb(255,255,255));
        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart1.getLegend().setEnabled(false);
        YAxis yAxis1 = chart1.getAxisRight();
        yAxis1.setTextColor(Color.rgb(255,255,255));




        BarData data2 = new BarData(getXAxisValues(), getDataSet2());
        chart2.setData(data2);
        chart2.setDescription("");
        chart2.animateXY(2000, 2000);
        chart2.invalidate();
        chart2.setBackgroundColor(Color.rgb(16,23,76));
        chart2.setDrawingCacheBackgroundColor(Color.rgb(0,0,0));
        chart2.setDrawGridBackground(false);

        XAxis xAxis2 = chart2.getXAxis();
        xAxis2.setTextColor(Color.rgb(255,255,255));
        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart2.getLegend().setEnabled(false);
        YAxis yAxis2 = chart2.getAxisRight();
        yAxis2.setTextColor(Color.rgb(255,255,255));

        chart2.getXAxis().setDrawGridLines(false);
        chart2.getAxisLeft().setDrawGridLines(false);
        chart2.getAxisRight().setDrawGridLines(false);

        BarData data3 = new BarData(getXAxisValues(), getDataSet3());
        chart3.setData(data3);
        chart3.setDescription("");
        chart3.animateXY(2000, 2000);
        chart3.invalidate();
        chart3.setBackgroundColor(Color.rgb(16,23,76));
        chart3.setDrawingCacheBackgroundColor(Color.rgb(0,0,0));
        chart3.setDrawGridBackground(false);

        XAxis xAxis3 = chart3.getXAxis();
        xAxis3.setTextColor(Color.rgb(255,255,255));
        xAxis3.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart3.getLegend().setEnabled(false);
        YAxis yAxis3 = chart3.getAxisRight();
        yAxis3.setTextColor(Color.rgb(255,255,255));

        chart3.getXAxis().setDrawGridLines(false);
        chart3.getAxisLeft().setDrawGridLines(false);
        chart3.getAxisRight().setDrawGridLines(false);

        return rootView;
    }
    private ArrayList<IBarDataSet> getDataSet1() {

        Random random =new Random();

        ArrayList<IBarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1;
        for (int i=0; i<7;i++){
            v1 = new BarEntry(15.000f + random.nextInt(20),i);
            valueSet1.add(v1);
        }

//        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
//        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
//        valueSet1.add(v1e1);
//        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
//        valueSet1.add(v1e2);
//        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
//        valueSet1.add(v1e3);
//        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
//        valueSet1.add(v1e4);
//        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
//        valueSet1.add(v1e5);
//        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
//        valueSet1.add(v1e6);
//        BarEntry v1e7 = new BarEntry(100.000f, 6); // Jun
//        valueSet1.add(v1e7);



        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "");
        barDataSet1.setColor(Color.rgb(251, 192, 45));
        barDataSet1.setBarShadowColor(Color.rgb(16,23,76));



        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);

        return dataSets;
    }

    private ArrayList<IBarDataSet> getDataSet2(){
        ArrayList<IBarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        Random random = new Random();

        BarEntry v1;
        for (int i=0; i<7;i++){
            v1 = new BarEntry(30.000f + random.nextInt(50),i);
            valueSet2.add(v1);
        }

//        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
//        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
//        valueSet2.add(v2e1);
//        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
//        valueSet2.add(v2e2);
//        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
//        valueSet2.add(v2e3);
//        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
//        valueSet2.add(v2e4);
//        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
//        valueSet2.add(v2e5);
//        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
//        valueSet2.add(v2e6);
//        BarEntry v2e7 = new BarEntry(80.000f, 6); // Jun
//        valueSet2.add(v2e7);


        BarDataSet barDataSet2 = new BarDataSet(valueSet2,"");
        barDataSet2.setColor(Color.rgb(0, 188, 212));
        barDataSet2.setBarShadowColor(Color.rgb(16,23,76));


        dataSets = new ArrayList<>();
        dataSets.add(barDataSet2);

        return dataSets;
    }

    private ArrayList<IBarDataSet> getDataSet3(){
        ArrayList<IBarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet3 = new ArrayList<>();

        Random random = new Random();

        BarEntry v1;
        for (int i=0; i<7;i++){
            v1 = new BarEntry(random.nextFloat()*100,i);
            valueSet3.add(v1);
        }
//
//        BarEntry v3e1 = new BarEntry(150.000f, 0); // Jan
//        valueSet3.add(v3e1);
//        BarEntry v3e2 = new BarEntry(90.000f, 1); // Feb
//        valueSet3.add(v3e2);
//        BarEntry v3e3 = new BarEntry(120.000f, 2); // Mar
//        valueSet3.add(v3e3);
//        BarEntry v3e4 = new BarEntry(60.000f, 3); // Apr
//        valueSet3.add(v3e4);
//        BarEntry v3e5 = new BarEntry(20.000f, 4); // May
//        valueSet3.add(v3e5);
//        BarEntry v3e6 = new BarEntry(80.000f, 5); // Jun
//        valueSet3.add(v3e6);
//        BarEntry v3e7 = new BarEntry(80.000f, 6); // Jun
//        valueSet3.add(v3e7);


        BarDataSet barDataSet3 = new BarDataSet(valueSet3, "");
        barDataSet3.setColor(Color.rgb(216, 216, 216));
        barDataSet3.setBarShadowColor(Color.rgb(16,23,76));

        dataSets = new ArrayList<>();

        dataSets.add(barDataSet3);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("SUN");
        xAxis.add("MON");
        xAxis.add("TUE");
        xAxis.add("WED");
        xAxis.add("THU");
        xAxis.add("FRI");
        xAxis.add("SAT");
        return xAxis;
    }
}
