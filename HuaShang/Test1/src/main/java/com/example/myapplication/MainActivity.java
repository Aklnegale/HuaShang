package com.example.myapplication;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private List<Fragment> fragmentList  =  new ArrayList<>();
    FragmentAdapter adapter;
    ViewPager viewPager;
    TextView tv1,tv2,tv3;
    ImageView iv;
    Fragment f1,f2,f3;
    public static int  currentIndex;
    public static int  screenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        viewPager = (ViewPager) this.findViewById(R.id.viewpager);
        tv1 = (TextView) this.findViewById(R.id.tv1);
        tv2 = (TextView) this.findViewById(R.id.tv2);
        tv3 = (TextView) this.findViewById(R.id.tv3);
        iv  = (ImageView) this.findViewById(R.id.iv);
        Bundle bundle = new Bundle();
        bundle.putString("text","文本一");
        f1 = new Afragment();
        f1.setArguments(bundle);
        fragmentList.add(f1);
        f2 = new Afragment();
        bundle.putString("text","文本二");
        f2.setArguments(bundle);
        fragmentList.add(f2);
        f3 = new Afragment();
        bundle.putString("text","文本三");
        f3.setArguments(bundle);
        fragmentList.add(f3);
        adapter = new FragmentAdapter(this.getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                resetTextView();
                switch (position) {
                    case 0:
                        tv1.setTextColor(Color.BLUE);
                        break;
                    case 1:
                        tv2.setTextColor(Color.BLUE);
                        break;
                    case 2:
                        tv3.setTextColor(Color.BLUE);
                        break;
                }
                currentIndex = position;
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)iv.getLayoutParams();
                Log.e("offset:",positionOffset + "");

                if (currentIndex == 0 && position == 0)// 0->1\
                {
                    layoutParams.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));

                } else if (currentIndex == 1 && position == 0) // 1->0
                {
                    layoutParams.leftMargin = (int) (-(1 - positionOffset)
                            * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));

                } else if (currentIndex == 1 && position == 1) // 1->2
                {
                    layoutParams.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));
                } else if (currentIndex == 2 && position == 1) // 2->1
                {
                    layoutParams .leftMargin = (int) (-(1 - positionOffset)
                            * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));
                }
                iv.setLayoutParams(layoutParams );
            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    /**
     * 设置滑动条的宽度为屏幕的1/3(根据Tab的个数而定)
     */
    private void initTabLineWidth() {
        DisplayMetrics dpMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay()
                .getMetrics(dpMetrics);
        screenWidth = dpMetrics.widthPixels;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) iv.getLayoutParams();
        lp.width = screenWidth / 3;
        iv.setLayoutParams(lp);
    }

    /**
     * 重置颜色
     */
    private void resetTextView() {
        tv1.setTextColor(Color.BLACK);
        tv2.setTextColor(Color.BLACK);
        tv3.setTextColor(Color.BLACK);
    }

}


