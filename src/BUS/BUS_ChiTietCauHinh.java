/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_ChiTietCauHinh;
import DTO.DTO_ChiTietCauHinh;
import java.util.ArrayList;


/**
 *
 * @author Kiet
 */
public class BUS_ChiTietCauHinh {
    public DAO_ChiTietCauHinh chitietproduct = new DAO_ChiTietCauHinh();
    private ArrayList<DTO_ChiTietCauHinh> listdetailProduct = new ArrayList<>();
    
    public BUS_ChiTietCauHinh() {

    }
    
    public void insert(DTO_ChiTietCauHinh t) {
        chitietproduct.insert(t);
    }
    
    public int getmacauhinhnew(int idsp) {
        return chitietproduct.getNextID(idsp);
    }

    public ArrayList<DTO_ChiTietCauHinh> getCauHinhbyID(int id) {
        return chitietproduct.getCauHinhbyID(id);
    }

    public ArrayList<DTO_ChiTietCauHinh> getAllChiTietCauHinh(String id) {
        return chitietproduct.selectAll(id);
    }

    public int getMaxID(int masanpham) {
        return chitietproduct.getMaxID(masanpham);
    }
}
