/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_NhanVien;
import DTO.DTO_NhanVien;
import java.util.ArrayList;

/**
 *
 * @author KIET
 */
public class BUS_NhanVien {
    public DAO_NhanVien nv = new DAO_NhanVien();

    public BUS_NhanVien() {
    }
     public ArrayList<DTO_NhanVien> getAllData() {
        return nv.getAllData();
    }
    
    public void insert(DTO_NhanVien t) {
        nv.insert(t);
    }

    public void update(DTO_NhanVien t) {
        nv.update(t);
    }

    public void delete(int id) {
        nv.delete(id);
    }
    
}
