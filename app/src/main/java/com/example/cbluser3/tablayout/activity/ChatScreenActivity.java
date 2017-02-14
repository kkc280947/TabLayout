package com.example.cbluser3.tablayout.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.adapter.ChatAdapter;
import com.example.cbluser3.tablayout.databaseHandler.ContactDatabaseHandler;
import com.example.cbluser3.tablayout.model.ChatModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by cbluser3 on 11/2/17.
 */

public class ChatScreenActivity extends AppCompatActivity {
    int recieverId;
    EditText etChat;
    Button btnSend;
    Toolbar toolbar;
    String url;
    String address;
    AppCompatImageView imageView;
    RecyclerView recyclerViewChat;
    final int statusCodeSender = 0;
    final int statusCodeReciever = 1;
    ChatAdapter chatAdapter;
    ContactDatabaseHandler contactDatabaseHandler;
    List<ChatModel> chatModelList = new ArrayList<>();
    String chat;
    Date date;
    Calendar calendar;
    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "MainActivity";
    String time;
    CoordinatorLayout coordinatorLayout;
    FloatingActionButton btnSelectImage;
    AppCompatImageView imgView;
    Uri selectedImageUri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_screen_activity);
        recieverId = getIntent().getExtras().getInt("position");
        toolbar = (Toolbar) findViewById(R.id.tool_chat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        time = getTime();
       // imageView = (AppCompatImageView) findViewById(R.id.ivTest);

        recyclerViewChat = (RecyclerView) findViewById(R.id.rvChatList);
        contactDatabaseHandler = new ContactDatabaseHandler(this);
        chatModelList = contactDatabaseHandler.getChats(recieverId);

        List<ChatModel> contacts = contactDatabaseHandler.getChats(recieverId);

        for (ChatModel cn : contacts) {
            String log = "Id: " + cn.getKey_id() + " ,Name: " + cn.getChats() + " ,Phone: " + cn.getStatusCode();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        etChat = (EditText) findViewById(R.id.etMessage);
        btnSend = (Button) findViewById(R.id.btSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chat = etChat.getText().toString();
                etChat.setText(null);

                Toast.makeText(ChatScreenActivity.this, time, Toast.LENGTH_SHORT).show();
                contactDatabaseHandler.addChats(new ChatModel(recieverId, chat, 1, null, statusCodeSender,time));
                contactDatabaseHandler.addChats(new ChatModel(recieverId, chat, 1, null, statusCodeReciever,time));
                chatModelList.clear();
                chatModelList.addAll(contactDatabaseHandler.getChats(recieverId));

                /*chatModelList.add(contactDatabaseHandler.addChats(new ChatModel(recieverId,chat,statusCodeSender)));
                chatModelList.add(contactDatabaseHandler.addChats(new ChatModel(recieverId,chat,statusCodeReciever)));*/
                chatAdapter.notifyDataSetChanged();
                LinearLayoutManager llm = (LinearLayoutManager) recyclerViewChat.getLayoutManager();

                llm.scrollToPosition(chatModelList.size());
                /*List<ChatModel> contacts = contactDatabaseHandler.getChats(recieverId);

                for (ChatModel cn : contacts) {
                    String log = "Id: "+cn.getKey_id()+" ,Name: " + cn.getChats() + " ,Phone: " + cn.getStatusCode();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }*/

            }
        });

        chatAdapter = new ChatAdapter(this, chatModelList);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewChat.setAdapter(chatAdapter);

    }

    public String getTime() {

        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd");
        String dateString = sdf.format(date);
        return dateString;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.upImage) {
            openImageChooser();
//            contactDatabaseHandler.addChats(new ChatModel(recieverId,"",0,address,statusCodeReciever));
        } else if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {

                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {

                    String path = getPathFromURI(selectedImageUri);
                    address = path;
                    Log.i(TAG, "Image Path : " + path);
                    insertUrl(path);

                }
            }

            contactDatabaseHandler.addChats(new ChatModel(recieverId, null, 0, address, statusCodeSender,time));
            chatModelList.clear();
            chatModelList.addAll(contactDatabaseHandler.getChats(recieverId));
            //  Toast.makeText(ChatScreenActivity.this,chatModelList.toString(),Toast.LENGTH_LONG).show();
            List<ChatModel> contacts = contactDatabaseHandler.getChats(recieverId);

            for (ChatModel cn : contacts) {
                String log = "Id: " + cn.getKey_id() + " ,Name: " + cn.getImageUrl() + " ,Phone: " + cn.getDate();
                // Writing Contacts to log
                Log.d("Name: ", log);

            }

            chatAdapter = new ChatAdapter(this, chatModelList);
            recyclerViewChat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        }
    }

    public void insertUrl(String url) {
        this.url = url;
    }


    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);

            Log.d("path", res);
        }

        cursor.close();
        return res;

    }
}
