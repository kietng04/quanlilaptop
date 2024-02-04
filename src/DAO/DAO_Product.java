/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.JDBCUtil;
import DTO.DTO_Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kiet
 */
public class DAO_Product implements DAOInterface<DTO_Product>{
    
    public static DAO_Product getInstance() {
        return new DAO_Product();
    }
    
    @Override
    public int insert(DTO_Product t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(DTO_Product t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DTO_Product> getAllData() {
       ArrayList<DTO_Product> result = new ArrayList<DTO_Product>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM sanpham WHERE `trangthai`= 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int madm = rs.getInt("masanpham");
                String tendm = rs.getString("tensanpham");
                String hinhanh = rs.getString("hinhanh");
                String boxuly = rs.getString("boxuly");
                String hedieuhanh = rs.getString("hedieuhanh");
                int soluong = rs.getInt("soluong");
                String thoigianbaohanh = rs.getString("thoigianbaohanh");
                String maloai = rs.getString("maloai");
                String khuvuckho = rs.getString("khuvuckho");
                int trangthai = rs.getInt("trangthai");
                DTO_Product sp = new DTO_Product(madm,tendm,boxuly,hedieuhanh,soluong, khuvuckho,hinhanh, maloai, thoigianbaohanh,trangthai);
                result.add(sp);
            }
            JDBCUtil.close(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public DTO_Product selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
