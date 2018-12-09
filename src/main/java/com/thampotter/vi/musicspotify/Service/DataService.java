package com.thampotter.vi.musicspotify.Service;

import com.thampotter.vi.musicspotify.Model.Album;
import com.thampotter.vi.musicspotify.Model.Playlist;
import com.thampotter.vi.musicspotify.Model.QuangCao;
import com.thampotter.vi.musicspotify.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("songbanner.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("playlistforcurrent.php")
    Call<List<Playlist>> GetplaylistCurrentDay();

    @GET("chudeforday.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumforday.php")
    Call<List<Album>> GetAlbumHot();
}
