package com.example.scrollbehavioursandlayoutdesigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

public class ParallaxWithTabActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_with_parallax);
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
        mCollapsingToolbarLayout = findViewById(R.id.collapsibleToolbarLayout);
        mCollapsingToolbarLayout.setTitle("Walchensee");
        mCollapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(DummyFragment.newInstance(), "Tab1");
        viewPagerAdapter.addFragment(new DummyFragment(), "Tab2");
        viewPagerAdapter.addFragment(new DummyFragment(), "Tab3");
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
