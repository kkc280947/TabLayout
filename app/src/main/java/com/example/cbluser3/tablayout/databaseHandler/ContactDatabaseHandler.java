package com.example.cbluser3.tablayout.databaseHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.cbluser3.tablayout.model.ChatModel;
import com.example.cbluser3.tablayout.model.ContactsModel;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.INTEGER;

/**
 * Created by cbluser3 on 11/2/17.
 */
public class ContactDatabaseHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactchats";
    private static final String TABLE_Chats = "chats";
    private static final String KEY_ID = "id";
    private static final String RECIEVER_ID = "recieve_id";
    private static final String STATUS_CODE="chat_code";
    private static final String CHAT_Message="chat";
    private static final String CHAT_TYPE="type";
    private static final String IMAGE_URL="imgUrl";
    private static final String DATE="date";

    public ContactDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_Chats + "("
                +KEY_ID+" INTEGER PRIMARY KEY,"+ RECIEVER_ID+" TEXT,"
                +CHAT_Message+" TEXT,"+CHAT_TYPE+" TEXT,"
                +IMAGE_URL+" TEXT,"+ STATUS_CODE + " TEXT,"+ DATE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Chats);
        onCreate(db);
    }

    public void addChats(ChatModel chatModel){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        Log.d("hfhf", String.valueOf(chatModel.getType()));
        if(chatModel.type==1){
            values.put(RECIEVER_ID, chatModel.getRecieverId());
            values.put(CHAT_Message, chatModel.getChats());
            values.put(CHAT_TYPE,chatModel.getType());
            values.put(IMAGE_URL,chatModel.getImageUrl());
            values.put(STATUS_CODE, chatModel.getStatusCode());
            values.put(DATE,chatModel.getDate());

        }

        else if(chatModel.type==0){
            if(chatModel.getImageUrl()!=null){

                values.put(RECIEVER_ID, chatModel.getRecieverId());
                values.put(CHAT_Message, chatModel.getChats());
                values.put(CHAT_TYPE,chatModel.getType());
                values.put(IMAGE_URL,chatModel.getImageUrl());
                values.put(STATUS_CODE, chatModel.getStatusCode());
                values.put(DATE,chatModel.getDate());

            }
            else{
              return;

            }
        }


        db.insert(TABLE_Chats,null,values);
        db.close();
    }

    public List<ChatModel> getChats(int recieveId) {

        Log.d("rec id",String.valueOf(recieveId));
        List<ChatModel> chatModelList = new ArrayList<ChatModel>();
        // Select All Query
        int id = recieveId;
        String selectQuery = "SELECT  * FROM " + TABLE_Chats + " WHERE " + RECIEVER_ID + "="+id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ChatModel chatModel = new ChatModel();
                chatModel.setKey_id(Integer.parseInt(cursor.getString(0)));
                chatModel.setRecieverId(Integer.parseInt(cursor.getString(1)));
                chatModel.setChats(cursor.getString(2));
                chatModel.setType(Integer.parseInt(cursor.getString(3)));
                chatModel.setImageUrl(cursor.getString(4));
                chatModel.setStatusCode(Integer.parseInt(cursor.getString(5)));
                chatModel.setDate(cursor.getString(6));
                chatModelList.add(chatModel);
            } while (cursor.moveToNext());

        }
        return chatModelList;
    }

    public int getChatCount(int recieveId) {
        int id=recieveId;
        String countQuery = "SELECT  * FROM " + TABLE_Chats+ " WHERE " + RECIEVER_ID+ "="+id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);


        // return count
        return cursor.getCount();
    }
}
