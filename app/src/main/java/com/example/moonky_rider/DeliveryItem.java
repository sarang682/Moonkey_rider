package com.example.moonky_rider;

public class DeliveryItem {
    private int num;
    private String address; //도착지 의미함
    private int price;

    public DeliveryItem(int num, String address, int price) {
        this.num = num;
        this.address = address;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
