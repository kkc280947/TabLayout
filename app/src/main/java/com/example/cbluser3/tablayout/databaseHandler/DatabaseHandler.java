package com.example.cbluser3.tablayout.databaseHandler;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.model.ContactsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 11/2/17.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";

    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    public void addContact(ContactsModel contact) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.name);
        values.put(KEY_PH_NO, contact.phoneNo);
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public ContactsModel getContact(int recieverId){
        int id=recieverId;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ContactsModel contactModel = new ContactsModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contactModel;
    }

    public List<ContactsModel> getAllContacts() {
        List<ContactsModel> contactList = new ArrayList<ContactsModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ContactsModel contactModel = new ContactsModel();
                contactModel.setKey_id(Integer.parseInt(cursor.getString(0)));
                contactModel.setName(cursor.getString(1));
                contactModel.setPhoneNo(cursor.getString(2));
                // Adding contact to list
                contactList.add(contactModel);
            } while (cursor.moveToNext());
        }


        return contactList;
    }

    public int getContactCount() {

        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);


        // return count
        return cursor.getCount();
    }


}
