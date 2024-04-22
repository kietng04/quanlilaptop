/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_ChiTietPhieuNhap;
import DAO.DAO_PhieuNhap;
import DTO.DTO_ChiTietPhieuNhap;
import DTO.DTO_PhieuNhap;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 *
 * @author KIET
 */
public class BUS_PhieuNhap {
    public final DAO_PhieuNhap phieunhapDAO = new DAO_PhieuNhap();
   public final DAO_ChiTietPhieuNhap ctPhieuNhapDAO = new DAO_ChiTietPhieuNhap();
    
    ArrayList<DTO_PhieuNhap> listPhieuNhap;

    public BUS_PhieuNhap() {
    }

    public ArrayList<DTO_PhieuNhap> getAll() {
        this.listPhieuNhap = phieunhapDAO.getAllData();
        return this.listPhieuNhap;
    }

    public DTO_ChiTietPhieuNhap findCT(ArrayList<DTO_ChiTietPhieuNhap> ctphieu, int mapb) {
        DTO_ChiTietPhieuNhap p = null;
        int i = 0;
        while (i < ctphieu.size() && p == null) {
            if (ctphieu.get(i).getMaphienbansp() == mapb) {
                p = ctphieu.get(i);
            } else {
                i++;
            }
        }
        return p;
    }

    public long getTongTien(ArrayList<DTO_ChiTietPhieuNhap> ctphieu) {
        long result = 0;
        for (DTO_ChiTietPhieuNhap item : ctphieu) {
            result += item.getDongia() * item.getSoluong();
        }
        return result;
    }

    public boolean add(DTO_PhieuNhap phieu, ArrayList<DTO_ChiTietPhieuNhap> ctPhieu) {
        boolean check = phieunhapDAO.insert(phieu) != 0;
        ctPhieu.forEach((ctPhieu1) -> {
            ctPhieu1.setMaphieu(phieu.getMaphieu());
        });
        if (check) {
            check = ctPhieuNhapDAO.insert(ctPhieu) != 0;
        }
        return check;
    }
    public int cancelPhieuNhap(int maphieu) {
        return phieunhapDAO.cancelPhieuNhap(maphieu);
    }
}
