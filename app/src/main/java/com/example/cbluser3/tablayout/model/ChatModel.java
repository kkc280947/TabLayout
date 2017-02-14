package com.example.cbluser3.tablayout.model;

import java.util.Date;

/**
 * Created by cbluser3 on 11/2/17.
 */

public class ChatModel {

    public String chats;
    public int recieverId;
    public int statusCode;
    public int key_id;
    public int type;
    public String imageUrl;
    public String date;

    public ChatModel(int recieverId, String chats, int type, String imageUrl, int statusCode,String date) {
        this.chats = chats;
        this.recieverId = recieverId;
        this.statusCode = statusCode;
        this.type = type;
        this.imageUrl = imageUrl;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ChatModel() {

    }

    public ChatModel(int recieverId, String chats, int statusCode) {
        this.chats = chats;
        this.statusCode = statusCode;
        this.recieverId = recieverId;
    }

    public String getChats() {
        return chats;
    }

    public void setChats(String chats) {
        this.chats = chats;
    }

    public int getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(int recieverId) {
        this.recieverId = recieverId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }




}
