/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;

import DAO.DAO_ChiTietSanPham;
import DTO.DTO_ChiTietCauHinh;
import DTO.DTO_ChiTietSanPham;

/**
 *
 * @author KIET
 */
public class BUS_ChiTietSanPham {
    private final DAO_ChiTietSanPham ctspDAO = new DAO_ChiTietSanPham();
    public BUS_ChiTietCauHinh pbspbus = new BUS_ChiTietCauHinh();
    public ArrayList<DTO_ChiTietCauHinh> listpbsp;
    public ArrayList<DTO_ChiTietSanPham> listctsp = new ArrayList<>();

    public BUS_ChiTietSanPham() {

    }
    public ArrayList<DTO_ChiTietSanPham> getAllByMaPBSP(int pbsp) {
        listctsp = ctspDAO.selectbyPb(pbsp);
        return listctsp;
    }

    public ArrayList<DTO_ChiTietSanPham> getAll() {
        return this.listctsp;
    }

    public DTO_ChiTietSanPham getByIndex(int index) {
        return this.listctsp.get(index);
    }

    public ArrayList<DTO_ChiTietSanPham> getAllByMaPhieuNhap(int maphieunhap) {
        return ctspDAO.selectbyPhieuNhap(maphieunhap);
    }
    
    public ArrayList<DTO_ChiTietSanPham> getAllByMaPhieuNhapAndMaPBSP(int mapn, int mapbsp) {
        return ctspDAO.getAllByMaPhieuNhapAndMaPBSP( mapn,  mapbsp);
    }
    
    // public ArrayList<ChiTietPhieuDTO> getChiTietPhieu_Type(int maphieunhap) {
    //     ArrayList<ChiTietPhieuNhapDTO> arr = ctPhieuNhapDAO.selectAll(Integer.toString(maphieunhap));
    //     ArrayList<ChiTietPhieuDTO> result = new ArrayList<>();
    //     for (ChiTietPhieuDTO i : arr) {
    //         result.add(i);
    //     }
    //     return result;


    }

