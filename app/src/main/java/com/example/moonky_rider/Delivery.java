package com.example.moonky_rider;

import java.io.Serializable;

public class Delivery implements Serializable {
    private String destination; //목적지 주소
    private int fee; //배달료
    private String store; //가게 이름
    private String address; //가게 주소
    private String requested; //요청사항
    private String c_phone; //손님 연락처
    private String s_phone; //가게 연락처

    public Delivery(String destination, int fee, String store, String address, String requested, String c_phone, String s_phone) {
        this.destination = destination;
        this.fee = fee;
        this.store = store;
        this.address = address;
        this.requested = requested;
        this.c_phone = c_phone;
        this.s_phone = s_phone;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
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

