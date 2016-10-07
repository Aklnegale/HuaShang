package com.example.application;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment {
    ViewPager viewPager;
    ViewPagerAdapterFirst vpadapterfirst;
    private  int [] imgArray = {R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5};
    private ImageView imageView;
    private ViewGroup pointgroup;
    private ImageView[] pointarr;
    private List<View> viewlist = new ArrayList<>();
    public FirstFragment() {
    }
    private void init(){
        viewPager = (ViewPager)getActivity().findViewById(R.id.vp_first_fragment);
        pointgroup = (ViewGroup)getActivity().findViewById(R.id.pointgroup);
        for(int i = 0;i <imgArray.length;i++)
        {
            imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imgArray[i]);
            imageView.setId(imgArray[i]);
            viewlist.add(imageView);
        }

        vpadapterfirst = new ViewPagerAdapterFirst(viewlist,getActivity());
        viewPager.setAdapter(vpadapterfirst);
        pointarr = new ImageView[imgArray.length];
       for(int i = 0;i < imgArray.length;i++)
       {
           ImageView point = new ImageView(getActivity());
           point.setLayoutParams(new ViewGroup.LayoutParams(10,10));
           pointarr[i] = point;
           if(i == 0)
           {
               pointarr[i].setBackgroundResource(R.drawable.pointw);
           }else{
               pointarr[i].setBackgroundResource(R.drawable.pointr);
           }
           pointgroup.addView(pointarr[i]);
       }
        Pointchangelistener pointlistener  = new Pointchangelistener();
        viewPager.setOnPageChangeListener(pointlistener);
        vpadapterfirst.notifyDataSetChanged();

    }
   public  class  Pointchangelistener implements ViewPager.OnPageChangeListener{

       @Override
       public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

       }

       @Override
       public void onPageSelected(int position) {
           for(int i = 0;i<pointarr.length;i++)
           {
               if(position == i)
               {
                   pointarr[position].setBackgroundResource(R.drawable.pointw);
               }else
               {
                   pointarr[i].setBackgroundResource(R.drawable.pointr);
               }
           }

       }

       @Override
       public void onPageScrollStateChanged(int state) {

       }
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        init();
        return super.onCreateView(inflater, container, savedInstanceState);

    }



}
