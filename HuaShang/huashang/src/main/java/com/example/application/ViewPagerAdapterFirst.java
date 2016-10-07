package com.example.application;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;



/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class ViewPagerAdapterFirst extends PagerAdapter {
    Context context;
    List<View>viewList = new ArrayList<>();
    public ViewPagerAdapterFirst(List<View> viewList,Context context) {
        this.viewList = viewList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(viewList.get(position));
        View view = viewList.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = v.getId();
                Toast.makeText(context,"点击了第"+ position+"幅图片",Toast.LENGTH_SHORT).show();
            }
        });
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}