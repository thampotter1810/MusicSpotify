package com.thampotter.vi.musicspotify.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thampotter.vi.musicspotify.Model.ChuDe;
import com.thampotter.vi.musicspotify.Model.TheLoai;
import com.thampotter.vi.musicspotify.Model.Theloaitrongngay;
import com.thampotter.vi.musicspotify.R;
import com.thampotter.vi.musicspotify.Service.APIService;
import com.thampotter.vi.musicspotify.Service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai extends Fragment {

    View view;
    HorizontalScrollView horizontalScrollView;
    TextView tvXemThemChuDeTheLoai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai,container,false);
        horizontalScrollView = view.findViewById(R.id.horizontalscrollview);
        tvXemThemChuDeTheLoai = view.findViewById(R.id.tvxemthem);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<Theloaitrongngay> callback = dataService.GetCategoryMusic();
        callback.enqueue(new Callback<Theloaitrongngay>() {
            @Override
            public void onResponse(Call<Theloaitrongngay> call, Response<Theloaitrongngay> response) {
                Theloaitrongngay theloaitrongngay = response.body();

                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(theloaitrongngay.getChuDe());

                final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
                theLoaiArrayList.addAll(theloaitrongngay.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(580,250);
                params.setMargins(10,20,10,30);
                for (int i = 0; i < (chuDeArrayList.size()); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (chuDeArrayList.get(i).getHinhChuDe() != null){
                        Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);
                    }
                    cardView.setLayoutParams(params);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                for (int j = 0; j < (theLoaiArrayList.size()); j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theLoaiArrayList.get(j).getHinhTheLoai() != null){
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(params);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<Theloaitrongngay> call, Throwable t) {
                Toast.makeText(getActivity(),"không thể load dữ liệu từ sever. vui lòng kiểm tra kết nối!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
