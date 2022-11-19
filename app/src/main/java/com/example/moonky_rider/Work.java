package com.example.moongky_rider;

public class Work {
    private String date; //승인요청일자
    private String rider_name; //요청자명

    public Work(String date, String rider_name) {
        this.date=date;
        this.rider_name=rider_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getRider_name() {
        return rider_name;
    }

    public void setRider_name(String rider_name) {
        this.rider_name = rider_name;
    }
}