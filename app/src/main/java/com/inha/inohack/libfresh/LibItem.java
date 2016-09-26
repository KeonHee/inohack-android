package com.inha.inohack.libfresh;
import com.google.api.client.util.Key;

import java.util.Calendar;
/**
 * Created by user on 2016-09-24.
 */

public class LibItem {

    int no;
    String name;
    String date;  // "2016-09-24"
    String time;  // "02:41:55.645455"
    double temperature;
    int humidity;
    int airPollution;

    public LibItem(){
    }

    public LibItem(int no, String name, String date, String time,
                   double temperature, int humidity, int airPollution) {
        setNo(no);
        setDate(date);
        setAirPollution(airPollution);
        setHumidity(humidity);
        setName(name);
        setTime(time);
        setTemperature(temperature);
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getAirPollution() {

        if(airPollution==1||airPollution==0){
            return "나쁨";
        }else if(airPollution==2){
            return "보통";
        }else {
            return "좋음";
        }
    }

    public void setAirPollution(int airPollution) {
        this.airPollution = airPollution;

    }
}
