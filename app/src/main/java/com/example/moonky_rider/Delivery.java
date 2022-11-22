package com.example.moonky_rider;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

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

//    protected Delivery(Parcel in) {
//        delivery_id = in.readLong();
//        address = in.readString();
//        call_check = in.readByte() != 0;
//        distance = in.readInt();
//        pay = in.readInt();
//        requests = in.readString();
//        order_id = in.readLong();
//        store_id = in.readLong();
//        uid = in.readLong();
//        total_pay = in.readLong();
//        delivery_check = in.readByte() != 0;
//    }
//
//    public static final Creator<Delivery> CREATOR=new Creator<Delivery>() {
//        @Override
//        public Delivery createFromParcel(Parcel in) {
//            return new Delivery(in);
//        }
//
//        @Override
//        public Delivery[] newArray(int size) {
//            return new Delivery[size];
//        }
//    };



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

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.Q)
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeLong(delivery_id);
//        dest.writeString(address);
//        dest.writeBoolean(call_check);
//        dest.writeInt(distance);
//        dest.writeInt(pay);
//        dest.writeString(requests);
//        dest.writeLong(order_id);
//        dest.writeLong(store_id);
//        dest.writeLong(uid);
//        dest.writeLong(total_pay);
//        dest.writeBoolean(delivery_check);
//    }
}

