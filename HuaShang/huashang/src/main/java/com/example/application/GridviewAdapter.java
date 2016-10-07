package com.example.application;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
class GridViewAdapter extends BaseAdapter {
    List<Drawable> drawableList = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public GridViewAdapter(Context context) {
      this.context = context;
      inflater = LayoutInflater.from(context);
    }

    public void  getImage(){
       drawableList.add(context.getResources().getDrawable(R.drawable.a)) ;
        drawableList.add(context.getResources().getDrawable(R.drawable.b));
        drawableList.add(context.getResources().getDrawable(R.drawable.c));
        drawableList.add(context.getResources().getDrawable(R.drawable.d));
        drawableList.add(context.getResources().getDrawable(R.drawable.e));
        drawableList.add(context.getResources().getDrawable(R.drawable.f));
    }
    @Override
    public int getCount() {
        return drawableList.size();
    }

    @Override
    public Object getItem(int position) {
        return drawableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      Holder holder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.home_gv_item,null);
            holder = new Holder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.gv_item_iv);
            convertView.setTag(holder);
        }else
        {
            holder =(Holder)convertView.getTag();
        }
           holder.imageView.setBackgroundDrawable(drawableList.get(position));
        return convertView;
    }

    public class Holder{
        ImageView imageView;
        Holder(){

        }

    }
}
