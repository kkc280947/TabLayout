package com.example.cbluser3.tablayout.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.cbluser3.tablayout.adapter.MyPagerAdapter;
import com.example.cbluser3.tablayout.R;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout tabLayout;
    MyPagerAdapter pagerAdapter;
    Toolbar tbToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbToolbar=(Toolbar)findViewById(R.id.tbTool);
        pager=(ViewPager)findViewById(R.id.pager);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);

        setSupportActionBar(tbToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ChatApp");
        pagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),3);

        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(pager);
        pager.setCurrentItem(1);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        else if(item.getItemId()==R.id.profile){
            Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.add){
            Intent intent=new Intent(MainActivity.this,AddContactActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_front,menu);
        return true;

    }
}
