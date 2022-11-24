package com.example.moonky_rider;


import java.io.Serializable;

public class Store implements Serializable {

    private String storeId; //가게 id
    private String name; //가게 이름
    private String address; // 주소
    private String description; //설명
    private String category; //카테고리
    private String contact; //연락처

    public Store(String storeId, String name, String address, String description, String category, String contact) {
        this.storeId = storeId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.category = category;
        this.contact = contact;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}