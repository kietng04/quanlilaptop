/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_NhaCungCap;

import java.util.ArrayList;

import DAO.DAOInterface;
/**
 *
 * @author KIET
 */
public class DAO_NhaCungCap implements DAOInterface<DTO_NhaCungCap>{
    // implemment all methods
    @Override
    public int insert(DTO_NhaCungCap t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(DTO_NhaCungCap t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTO_NhaCungCap> getAllData() {
        try {
            ArrayList<DTO_NhaCungCap> result = new ArrayList<DTO_NhaCungCap>();
            String sql = "SELECT * FROM nhacungcap WHERE `TrangThai`= 1";
            ResultSet rs = JDBCUtil.executeQuery(sql);
            while (rs.next()) {
                int mancc = rs.getInt("MaNCC");
                String tenncc = rs.getString("TenNCC");
                String diachi = rs.getString("DiaChi");
                String email = rs.getString("Email");
                String sdt = rs.getString("SDT");
                DTO_NhaCungCap ncc = new DTO_NhaCungCap(mancc, tenncc, diachi, email, sdt);
            }
    }

    @Override
    public DTO_NhaCungCap selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
