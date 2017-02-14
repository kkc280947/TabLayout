package com.example.cbluser3.tablayout.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 11/2/17.
 */

public class ContactsModel {

    public ContactsModel() {

    }

    public ContactsModel(String name, String phoneNo) {
        this.phoneNo = phoneNo;
        this.name = name;
    }

    public int key_id;
    public String name;
    public String phoneNo;
    public String imageId;
    List<ContactsModel> contactsModels=new ArrayList<>();

    public ContactsModel(List<ContactsModel> contactsModels, String imageId) {
        this.contactsModels = contactsModels;
        this.imageId = imageId;
    }

    public ContactsModel(int key_id, String name, String phoneNo) {
        this.key_id = key_id;
        this.phoneNo = phoneNo;
        this.name = name;
    }

    public ContactsModel(int key_id,String name) {
        this.name = name;
        this.key_id=key_id;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
