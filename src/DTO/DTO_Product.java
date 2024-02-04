/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Kiet
 */
public class DTO_Product {
    private int masanpham;
    private String tensanpham;
    private String boxuly;
    private String hedieuhanh;
    private int soluong;
    private String vitrikho;
    private String hinhsanpham;
    private String maloai;
    private String thoigianbaohanh;
    private int trangthai;
    
    public DTO_Product(int masanpham, String tensanpham, String boxuly, String hedieuhanh, int soluong, String vitrikho, String hinhsanpham, String maloai, String thoigianbaohanh, int trangthai) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.boxuly = boxuly;
        this.hedieuhanh = hedieuhanh;
        this.soluong = soluong;
        this.vitrikho = vitrikho;
        this.hinhsanpham = hinhsanpham;
        this.maloai = maloai;
        this.thoigianbaohanh = thoigianbaohanh;
        this.trangthai = trangthai;
    }
    
    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    // Getter và Setter cho tensanpham
    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    // Getter và Setter cho boxuly
    public String getBoxuly() {
        return boxuly;
    }

    public void setBoxuly(String boxuly) {
        this.boxuly = boxuly;
    }


    // Getter và Setter cho hedieuhanh
    public String getHedieuhanh() {
        return hedieuhanh;
    }

    public void setHedieuhanh(String hedieuhanh) {
        this.hedieuhanh = hedieuhanh;
    }

    // Getter và Setter cho soluong
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    // Getter và Setter cho vitrikho
    public String getVitrikho() {
        return vitrikho;
    }

    public void setVitrikho(String vitrikho) {
        this.vitrikho = vitrikho;
    }

    // Getter và Setter cho hinhsanpham
    public String getHinhsanpham() {
        return hinhsanpham;
    }

    public void setHinhsanpham(String hinhsanpham) {
        this.hinhsanpham = hinhsanpham;
    }

    // Getter và Setter cho maloai
    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    // Getter và Setter cho thoigianbaohanh
    public String getThoigianbaohanh() {
        return thoigianbaohanh;
    }

    public void setThoigianbaohanh(String thoigianbaohanh) {
        this.thoigianbaohanh = thoigianbaohanh;
    }

    // Getter và Setter cho trangthai
    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
