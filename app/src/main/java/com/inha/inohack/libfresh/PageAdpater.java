package com.inha.inohack.libfresh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by user on 2016-09-24.
 */
public class PageAdpater extends FragmentStatePagerAdapter {

    private int tabCount;

    public PageAdpater(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DayChartFragment dayTab = new DayChartFragment();
                return dayTab;
            case 1:
                WeekChartFragment weekTab = new WeekChartFragment();
                return weekTab;
            case 2:
                MonthChartFragment monthTab = new MonthChartFragment();
                return monthTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
