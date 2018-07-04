package com.design.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager mViewPager;

    private TabLayout.Tab one,two,three,four;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        initTabLayout();
        initTabs();
        initEvents();
    }

    private void initTabLayout() {
        mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(mViewPager.getAdapter().getCount());
        // 设置ViewPager的数据等
        mTablayout.setupWithViewPager(mViewPager);
        //适合很多tab
        //mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tab均分,适合少的tab
        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        //tab均分,适合少的tab,TabLayout.GRAVITY_CENTER
        //mTablayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    private void initTabs(){
        one = mTablayout.getTabAt(0);
        two = mTablayout.getTabAt(1);
        three = mTablayout.getTabAt(2);
        four = mTablayout.getTabAt(3);

        one.setIcon(R.drawable.ic_add_24dp);
        two.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
        three.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
        four.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment newfragment = new FiveFragment("吴小龙0");
        adapter.addFrag(newfragment, getString(R.string.page1));

        newfragment = new FiveFragment("吴小龙1");
        adapter.addFrag(newfragment, getString(R.string.page2));

        newfragment = new FiveFragment("吴小龙2");
        adapter.addFrag(newfragment, getString(R.string.page3));

        newfragment = new FiveFragment("吴小龙3");
        adapter.addFrag(newfragment, getString(R.string.page4));

        viewPager.setAdapter(adapter);
    }

    private void initEvents() {
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == mTablayout.getTabAt(0)) {
                    one.setIcon(R.drawable.ic_add_24dp);
                    two.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    three.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    four.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                } else if (tab == mTablayout.getTabAt(1)) {
                    two.setIcon(R.drawable.ic_link_24dp);
                    one.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    three.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    four.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                } else if (tab == mTablayout.getTabAt(2)) {
                    three.setIcon(R.drawable.ic_search_24dp);
                    two.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    one.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    four.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                }else if (tab == mTablayout.getTabAt(3)){
                    four.setIcon(R.drawable.ic_share_24dp);
                    two.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    three.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                    one.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
