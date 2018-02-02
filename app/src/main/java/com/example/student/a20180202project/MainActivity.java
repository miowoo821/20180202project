package com.example.student.a20180202project;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.student.a20180202project.adapter.viewpageradapter;
import com.example.student.a20180202project.fragments.Activity_Fragment;
import com.example.student.a20180202project.fragments.Change_Fragment;
import com.example.student.a20180202project.fragments.Main_Fragment;
import com.example.student.a20180202project.fragments.Order_Fragment;
import com.example.student.a20180202project.fragments.WebFragment;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    viewpageradapter My_vp_adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        My_vp_adpater=new viewpageradapter(getSupportFragmentManager());
        viewPager =(ViewPager)findViewById(R.id.viewpager1);
        viewPager.setAdapter(My_vp_adpater);
        tabLayout=(TabLayout)findViewById(R.id.tablayout1);

        //重點程式碼//
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        //兩個相互作用的程式碼
        //重點程式碼//

        setup_viewpager(viewPager);
        viewPager.setCurrentItem(2);//跳到第三個fragment(要先裝進去setup_viewpager跳轉才有用)
//          用延遲的方法跳轉(刪)
//        viewPager.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                viewPager.setCurrentItem(2);
//                Log.d("RRRRRRRRRRRRRRRRRRR",String.valueOf(viewPager.getCurrentItem()));
//            }
//        }, 100);
//        Log.d("RRRRRRRRRRRRRRRRRRR",String.valueOf(viewPager.getCurrentItem()));
    }



    public void setup_viewpager(ViewPager viewPager){
        My_vp_adpater=new viewpageradapter(getSupportFragmentManager());

        My_vp_adpater.addFragment(new Change_Fragment(),"change");
        My_vp_adpater.addFragment(new Order_Fragment(),"order");
        My_vp_adpater.addFragment(new Main_Fragment(),"Main");
        My_vp_adpater.addFragment(new Activity_Fragment(),"Activity");
        My_vp_adpater.addFragment(new WebFragment(),"web");

        viewPager.setAdapter(My_vp_adpater);
    }

}
