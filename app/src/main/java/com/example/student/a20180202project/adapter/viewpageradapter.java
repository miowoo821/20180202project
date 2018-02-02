package com.example.student.a20180202project.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.student.a20180202project.fragments.Activity_Fragment;
import com.example.student.a20180202project.fragments.Change_Fragment;
import com.example.student.a20180202project.fragments.Main_Fragment;
import com.example.student.a20180202project.fragments.Order_Fragment;
import com.example.student.a20180202project.fragments.WebFragment;

import java.util.ArrayList;

/**
 * Created by Student on 2018/2/2.
 */

public class viewpageradapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentList=new ArrayList<>();
    ArrayList<String>   fragmentTitleList=new ArrayList<>();

    public  viewpageradapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return Change_Fragment.newInstance("A","1");
            case 1:
                return Order_Fragment.newInstance("B","2");
            case 2:
                return Main_Fragment.newInstance("C","3");
            case 3:
                return Activity_Fragment.newInstance("D","4");
            case 4:
                return WebFragment.newInstance("E","5");
            default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    //寫一個新增fragment的功能
    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }
}
