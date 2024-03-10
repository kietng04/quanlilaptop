/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.JDBCUtil;
import DTO.DTO_Brand;
import DTO.DTO_ChiTietCauHinh;
import DTO.DTO_Kho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kiet
 */
public class DAO_ChiTietCauHinh implements DAOInterface_Detail<DTO_ChiTietCauHinh> {

    @Override
    public int insert(ArrayList<DTO_ChiTietCauHinh> t) {
        int result = 0;
        for (int i = 0; i < t.size(); i++) {
            try {
                Connection con = (Connection) JDBCUtil.getConnectDB();
                String sql = "INSERT INTO `phienbansanpham`(`maphienbansp`, `masanpham`, `rom`, `ram`, `boxuly`, `gianhap`, `giaxuat`,`soluongton`) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                pst.setInt(1, t.get(i).getMaphienbansp());
                pst.setInt(2, t.get(i).getMasanpham());
                pst.setInt(3, t.get(i).getRom());
                pst.setInt(4, t.get(i).getRam());
                pst.setInt(5, t.get(i).getGianhap());
                pst.setInt(6, t.get(i).getGiaxuat());
                pst.setInt(7, t.get(i).getSoluongton());
                result = pst.executeUpdate();
                JDBCUtil.close(con);
            } catch (SQLException ex) {
                System.out.println("omg");
            }
        }
        return result;
    }
    
    public int insert(DTO_ChiTietCauHinh t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "INSERT INTO `phienbansanpham`(`maphienbansp`, `masanpham`, `rom`, `ram`, `gianhap`, `giaxuat`, `soluongton`, `trangthai`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaphienbansp());
            pst.setInt(2, t.getMasanpham());
            pst.setInt(3, t.getRom());
            pst.setInt(4, t.getRam());
            pst.setInt(5, t.getGianhap());
            pst.setInt(6, t.getGiaxuat());
            pst.setInt(7, t.getSoluongton());
            pst.setInt(8, 1);
            result = pst.executeUpdate();
            JDBCUtil.close(con);
        } catch (SQLException ex) {
            System.out.println("omgw");
        }
        return result;
    }

    @Override
    public void delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ArrayList<DTO_ChiTietCauHinh> t, String pk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DTO_ChiTietCauHinh> selectAll(String t) {
        int id = Integer.parseInt(t);
        // select all chitietcauhinh from db 
        ArrayList<DTO_ChiTietCauHinh> result = new ArrayList<DTO_ChiTietCauHinh>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM phienbansanpham WHERE masanpham = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphienbansp = rs.getInt("maphienbansp");
                int masanpham = rs.getInt("masanpham");
                int rom = rs.getInt("rom");
                int ram = rs.getInt("ram");
                int gianhap = rs.getInt("gianhap");
                int giaxuat = rs.getInt("giaxuat");
                int soluongton = rs.getInt("soluongton");
                DTO_ChiTietCauHinh sp = new DTO_ChiTietCauHinh(maphienbansp, masanpham, rom, ram, gianhap, giaxuat, soluongton);
                result.add(sp);
            }
            JDBCUtil.close(con);
        } catch (Exception e) {
            System.out.println("omg");
        }
        return result;
    }
    
    public int getNextID(int idsp) {
        try {
             Connection con = (Connection) JDBCUtil.getConnectDB();
             String sql = "SELECT COUNT(*) AS soluong FROM phienbansanpham where masanpham = ?";
             PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
             pst.setInt(1, idsp);
             ResultSet rs = (ResultSet) pst.executeQuery();
             if (rs.next()) {
                int soLuong = rs.getInt("soluong");
                return soLuong + 1;
             }
        } catch(SQLException e) {
            return -12;
        }
        return -1;
    }

    public ArrayList<DTO_ChiTietCauHinh> getCauHinhbyID(int id) {
        ArrayList<DTO_ChiTietCauHinh> result = new ArrayList<DTO_ChiTietCauHinh>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM sanpham, phienbansanpham WHERE sanpham.masanpham = phienbansanpham.masanpham AND sanpham.masanpham = ? AND phienbansanpham.trangthai = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = (ResultSet) pst.executeQuery();
            
            while (rs.next()) {
                System.out.println("ccccccc");
                int maphienbansp = rs.getInt("maphienbansp");
                int masanpham = rs.getInt("masanpham");
                int rom = rs.getInt("rom");
                int ram = rs.getInt("ram");
                int gianhap = rs.getInt("gianhap");
                int giaxuat = rs.getInt("giaxuat");
                int soluongton = rs.getInt("soluongton");
                int trangthai = rs.getInt("trangthai");
                DTO_ChiTietCauHinh sp = new DTO_ChiTietCauHinh(maphienbansp, masanpham, rom, ram, gianhap, giaxuat, soluongton);
                result.add(sp);
            }
            JDBCUtil.close(con);
        } catch (Exception e) {
        }
        return result;
    }
    
    public int getMaxID(int masanpham) {
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT MAX(maphienbansp) AS maxid FROM phienbansanpham WHERE masanpham = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, masanpham);
            ResultSet rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                int maxid = rs.getInt("maxid");
                return maxid;
            }
        } catch (SQLException e) {
            return -1;
        }
        return -1;
    }
}
