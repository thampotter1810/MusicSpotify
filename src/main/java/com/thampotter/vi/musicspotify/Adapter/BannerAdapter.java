package com.thampotter.vi.musicspotify.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thampotter.vi.musicspotify.Model.QuangCao;
import com.thampotter.vi.musicspotify.R;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    Context context;
    ArrayList<QuangCao> list;

    public BannerAdapter(Context context, ArrayList<QuangCao> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list,null);

        ImageView imgbackground = view.findViewById(R.id.imgviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imgviewbanner);
        TextView tvtitlebaihat = view.findViewById(R.id.titlebannerbaihat);
        TextView tvnoidung = view.findViewById(R.id.texviewnoidung);

        Picasso.with(context).load(list.get(position).getHinhAnh()).into(imgbackground);
        Picasso.with(context).load(list.get(position).getHinhBaiHat()).into(imgsongbanner);
        tvtitlebaihat.setText(list.get(position).getTenBaiHat());
        tvnoidung.setText(list.get(position).getNoiDung());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
