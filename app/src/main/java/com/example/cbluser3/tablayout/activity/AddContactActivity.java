package com.example.cbluser3.tablayout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.databaseHandler.DatabaseHandler;
import com.example.cbluser3.tablayout.model.ContactsModel;

/**
 * Created by kris on 13/02/17.
 */
public class AddContactActivity extends AppCompatActivity{
    EditText etNameAdd,etPhoneAdd;
    Button btnAdd;
    DatabaseHandler db;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etNameAdd=(EditText)findViewById(R.id.etNameAdd);
        etPhoneAdd=(EditText)findViewById(R.id.etPhoneAdd);
        toolbar=(Toolbar)findViewById(R.id.tbToolAdd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setTitle("Add Contacts");

        btnAdd=(Button)findViewById(R.id.btnAddCon);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etNameAdd.getText().toString().trim();
                String phone=etPhoneAdd.getText().toString().trim();
                db=new DatabaseHandler(AddContactActivity.this);
                db.addContact(new ContactsModel(name,phone));
                Intent intent=new Intent(AddContactActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
