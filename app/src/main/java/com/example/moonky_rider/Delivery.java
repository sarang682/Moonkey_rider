package com.example.moonky_rider;

import java.io.Serializable;

public class Delivery implements Serializable {
    private long delivery_id;
    private String address;
    private boolean call_check;
    private int distance;
    private int pay;
    private String requests;
    private long order_id;
    private long store_id;
    private long uid;
    private long total_pay;
    private boolean delivery_check;

    public Delivery(long delivery_id, String address, boolean call_check, int distance, int pay, String requests, long order_id, long store_id, long uid, long total_pay, boolean delivery_check) {
        this.delivery_id = delivery_id;
        this.address = address;
        this.call_check = call_check;
        this.distance = distance;
        this.pay = pay;
        this.requests = requests;
        this.order_id = order_id;
        this.store_id = store_id;
        this.uid = uid;
        this.total_pay = total_pay;
        this.delivery_check = delivery_check;
    }

    public long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(long delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCall_check() {
        return call_check;
    }

    public void setCall_check(boolean call_check) {
        this.call_check = call_check;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getRequests() {
        return requests;
    }

    public void setRequests(String requests) {
        this.requests = requests;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getTotal_pay() {
        return total_pay;
    }

    public void setTotal_pay(long total_pay) {
        this.total_pay = total_pay;
    }

    public boolean isDelivery_check() {
        return delivery_check;
    }

    public void setDelivery_check(boolean delivery_check) {
        this.delivery_check = delivery_check;
    }
}

