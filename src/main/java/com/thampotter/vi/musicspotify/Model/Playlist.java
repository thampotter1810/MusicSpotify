package com.thampotter.vi.musicspotify.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playlist {

    @SerializedName("IdPlayList")
    @Expose
    private String idPlayList;
    @SerializedName("Ten")
    @Expose
    private String ten;
    @SerializedName("HinhAnh")
    @Expose
    private String hinhAnh;
    @SerializedName("Icon")
    @Expose
    private String icon;

    public String getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}