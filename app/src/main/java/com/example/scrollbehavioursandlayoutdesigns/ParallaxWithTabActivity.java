package com.example.scrollbehavioursandlayoutdesigns;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class ParallaxWithTabActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private FloatingActionButton mFabButton;
    private int fabColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_with_parallax);
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
        mFabButton = findViewById(R.id.fab);
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

        final int defaultColor = getResources().getColor(R.color.colorPrimaryDark);

        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.stanberg_see);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(@Nullable Palette palette) {
                    int mutedColor = palette.getMutedColor(defaultColor);
                    int fabColor = palette.getDarkVibrantColor(defaultColor);
                    int vibrantDarkColor = palette.getDarkMutedColor(defaultColor);
                    mCollapsingToolbarLayout.setContentScrimColor(mutedColor);
                    mCollapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
                    mFabButton.setBackgroundTintList(ColorStateList.valueOf(fabColor));
                }
            });
        } catch (Exception e) {
            mCollapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            );
            mCollapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimaryDark)
            );
        }

    }
}
