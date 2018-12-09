package com.thampotter.vi.musicspotify.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thampotter.vi.musicspotify.Adapter.BannerAdapter;
import com.thampotter.vi.musicspotify.Model.QuangCao;
import com.thampotter.vi.musicspotify.R;
import com.thampotter.vi.musicspotify.Service.APIService;
import com.thampotter.vi.musicspotify.Service.DataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment{

    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter adapter;
    Runnable runnable;
    Handler handler;
    int curentitem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bannner,container,false);
        anhXa();
        GetData();
        return view;
    }

    private void anhXa() {
        viewPager = view.findViewById(R.id.viewpagerquangcao);
        circleIndicator = view.findViewById(R.id.indicatordefault);
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<QuangCao>> call = dataService.GetDataBanner();
        call.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                adapter = new BannerAdapter(getActivity(),banners);
                viewPager.setAdapter(adapter);
                circleIndicator.setViewPager(viewPager);

                //set tự động chạy sau một khoảng thời gian nào đó
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        curentitem = viewPager.getCurrentItem();
                        curentitem++;
                        if (curentitem >= viewPager.getAdapter().getCount()){
                            curentitem = 0;
                        }
                        viewPager.setCurrentItem(curentitem, true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {

            }
        });
    }

}
