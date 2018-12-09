package com.thampotter.vi.musicspotify.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thampotter.vi.musicspotify.Adapter.AdapterMainViewPager;
import com.thampotter.vi.musicspotify.Fragment.Fragment_Tim_Kiem;
import com.thampotter.vi.musicspotify.Fragment.Fragment_Trang_Chu;
import com.thampotter.vi.musicspotify.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        init();
    }

    private void init() {
        AdapterMainViewPager adapterMainViewPager = new AdapterMainViewPager(getSupportFragmentManager());
        adapterMainViewPager.addFragment(new Fragment_Trang_Chu(),"Trang Chủ");
        adapterMainViewPager.addFragment(new Fragment_Tim_Kiem(),"Tìm Kiếm");
        viewPager.setAdapter(adapterMainViewPager);
        tabLayout.setupWithViewPager(viewPager);
        /*tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);*/
    }

    public void anhXa(){
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
    }
}
