package com.example.moonky_rider;

public class Store {

    private String name;
    private int store_id;
    private int price;
    private int number;
    private String address;
    private String destination;

    public Store(int price, int number, int store_id, String name, String address, String destination) {
        this.price = price;
        this.number = number;
        this.name = name;
        this.address = address;
        this.store_id = store_id;
        this.destination = destination;
    }

    public Store(int price, String name, String address) {
        this.price = price;
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getPrice() { return price; }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
}