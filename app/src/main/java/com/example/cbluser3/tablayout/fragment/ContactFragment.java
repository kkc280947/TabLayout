package com.example.cbluser3.tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.adapter.MyContactsListAdapter;
import com.example.cbluser3.tablayout.databaseHandler.DatabaseHandler;
import com.example.cbluser3.tablayout.model.ContactsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 3/2/17.
 */
public class ContactFragment extends Fragment{
    List<ContactsModel> contacts=new ArrayList<>();
    List<ContactsModel> contactsModelList=new ArrayList<>();
    RecyclerView recyclerContact;
    DatabaseHandler db;
    MyContactsListAdapter myContactsListAdapter;
    Button button;
    EditText etName;
    EditText etPhone;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.contact_fragment,container,false);

        db=new DatabaseHandler(getActivity());
      /*  db.addContact(new ContactsModel("Krishnakant","789212"));
        db.addContact(new ContactsModel("Anmol","789212"));
        db.addContact(new ContactsModel("Nishant","789212"));
        db.addContact(new ContactsModel("Eshav","789212"));
        db.addContact(new ContactsModel("Kay Kay","789212"));
        db.addContact(new ContactsModel("Bava","789212"));*/

        Log.d("Reading: ", "Reading all contacts..");
        contacts = db.getAllContacts();
        recyclerContact=(RecyclerView)view.findViewById(R.id.rvContact);
        myContactsListAdapter=new MyContactsListAdapter(getActivity(),contacts);
        recyclerContact.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerContact.setAdapter(myContactsListAdapter);

        return view;
    }
}
