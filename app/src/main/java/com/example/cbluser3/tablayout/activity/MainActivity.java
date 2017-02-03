package com.example.cbluser3.tablayout.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.cbluser3.tablayout.adapter.MyPagerAdapter;
import com.example.cbluser3.tablayout.R;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout tabLayout;
    MyPagerAdapter pagerAdapter;
    Toolbar tbToolbar;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbToolbar=(Toolbar)findViewById(R.id.tbTool);
        pager=(ViewPager)findViewById(R.id.pager);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello Snackbar", Snackbar.LENGTH_LONG).show();
            }
        });


        setSupportActionBar(tbToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       /* tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
*/
        pagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),3);

        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(pager);
        pager.setCurrentItem(1);

       /* tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            pager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });*/
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
        return super.onOptionsItemSelected(item);
    }
}
