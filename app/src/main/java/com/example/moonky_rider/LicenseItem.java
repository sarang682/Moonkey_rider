package com.example.moonky_rider;

public class LicenseItem {
    private String num; //면허증 면허 번호 또는 신분증 주번
    private String date; // 면허증 또는 신분증 발급일자 8자리

    public LicenseItem(String num, String date){
        this.num=num;
        this.date=date;
    }


    public String getNum(){
        return num;
    }
    public void setNum(String num){
        this.num=num;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }


}
