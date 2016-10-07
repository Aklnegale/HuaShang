package com.example.application;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity  {
    ViewPager viewPager;
    ViewpagerAdapter vpadapter;
    ArrayList<Fragment> fragmentlist ;
    GridView gv;
    GridViewAdapter gvadapter;
    Fragment f1,f2,f3,f4;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        SetDefaultFragment();
    }

    private void SetDefaultFragment() {
        f1 = new FirstFragment();
        f2 = new SecondFragment();
        f3 = new ThirdFragment();
        f4 = new ForthFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_content,f1);
        ft.commit();
        System.out.printf("setdafultfragment");
    }

    private void init() {
        viewPager = (ViewPager)this.findViewById(R.id.home_viewpager);
        vpadapter = new ViewpagerAdapter(this.getSupportFragmentManager(),fragmentlist);
        gv = (GridView)this.findViewById(R.id.home_gv);
        gvadapter = new GridViewAdapter(this);
        gv.setAdapter(gvadapter);
        gvadapter.getImage();
        gvadapter.notifyDataSetChanged();
        System.out.printf("init()");
    }
}
