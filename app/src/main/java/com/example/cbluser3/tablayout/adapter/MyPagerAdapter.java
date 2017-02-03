package com.example.cbluser3.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.cbluser3.tablayout.fragment.Fragment1;
import com.example.cbluser3.tablayout.fragment.Fragment2;
import com.example.cbluser3.tablayout.fragment.Fragment3;

/**
 * Created by cbluser3 on 3/2/17.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{
    int tabCount;

    public MyPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.tabCount=tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment1 tab1 = new Fragment1();
                return tab1;
            case 1:
                Fragment2 tab2 = new Fragment2();
                return tab2;
            case 2:
                Fragment3 tab3 = new Fragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Tab1";
            case 1: return "Tab2";
            case 2:  return  "tab3";
            default:return null;
        }
    }
}
