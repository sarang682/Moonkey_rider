package com.example.moonky_rider;

public class Delivery {
    private String destination; //목적지 주소
    private int fee; //배달료
    private String store; //가게 이름
    private String address; //가게 주소

    public Delivery(String destination, int fee, String store, String address) {
        this.destination = destination;
        this.fee = fee;
        this.store = store;
        this.address = address;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

