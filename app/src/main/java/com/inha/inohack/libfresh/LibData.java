package com.inha.inohack.libfresh;

import android.graphics.drawable.Drawable;

/**
 * Created by user on 2016-09-23.
 */
public class LibData {
    private Drawable iconDrawable ;
    private String titleStr ;
    private String descStr ;
    private String descStr2 ;

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public String getDescStr2() {
        return descStr2;
    }

    public void setDescStr2(String descStr2) {
        this.descStr2 = descStr2;
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
}
