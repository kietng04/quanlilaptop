/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_ChiTietSanPham;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConnectDB.JDBCUtil;
import DTO.DTO_ChiTietPhieuNhap;
import DTO.DTO_NhanVien;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KIET
 */
public class DAO_ChiTietSanPham  implements DAOInterface<DTO_ChiTietSanPham>{
    public static DAO_ChiTietSanPham getInstance(){
        return new DAO_ChiTietSanPham();
    }

    @Override
    public int insert(DTO_ChiTietSanPham t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "INSERT INTO `ctsanpham`(`maimei`, `maphienbansp`, `maphieunhap`, `tinhtrang`) VALUES (?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getImei());
            pst.setInt(2, t.getMaphienbansp());
            pst.setInt(3, t.getMaphieunhap());
            pst.setInt(4, t.getTinhtrang());
            result = pst.executeUpdate();
            JDBCUtil.close(con);
            JOptionPane.showMessageDialog(null, "Them thanh cong imei san pham: "+ result);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi insert imei san pham: " + ex.getMessage());
       
        }
        return result;
    }
    public int insert_mutiple(ArrayList<DTO_ChiTietSanPham> list) {
        int result = 0;
        for(DTO_ChiTietSanPham sp : list) {
            result += this.insert(sp);
        }
        return result;
    }

    @Override
    public int update(DTO_ChiTietSanPham t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "UPDATE `ctsanpham` SET `maphienbansp`=?,`maphieunhap`=?,`maphieuxuat`=?,`tinhtrang`=? WHERE `maimei`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaphienbansp());
            pst.setInt(2, t.getMaphieunhap());
            pst.setInt(3, t.getMaphieuxuat());
            pst.setInt(4, t.getTinhtrang());
            pst.setString(5, t.getImei());
            result = pst.executeUpdate();
            JDBCUtil.close(con);
            JOptionPane.showMessageDialog(null, "Cap nhat thanh cong imei san pham: "+ result);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi update imei san pham: " + ex.getMessage());
        }
        return result;
    }

    @Override
    public int delete(int t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "UPDATE `ctsanpham` SET `tinhtrang` = 0 WHERE  maimei = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            result = pst.executeUpdate();
            JDBCUtil.close(con);
            JOptionPane.showMessageDialog(null, "Xoa thanh cong imei san pham: "+ result);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi delete imei san pham: " + ex.getMessage());
        }
        return result;
        
    }

    @Override
    public ArrayList<DTO_ChiTietSanPham> getAllData() {

        ArrayList<DTO_ChiTietSanPham> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM ctsanpham";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int macauhinh = rs.getInt("phienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
                DTO_ChiTietSanPham ct = new DTO_ChiTietSanPham(imei, macauhinh, maphieunhap, maphieuxuat, tinhtrang);
                result.add(ct);
            }
            JDBCUtil.close(con);
            JOptionPane.showMessageDialog(null, "Lay imei san pham thanh cong: " + result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi lay imei san pham: " + e.getMessage());
        }
        return result;
    }

      
    public int reset(DTO_ChiTietSanPham t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "UPDATE `ctsanpham` SET `maphieuxuat`= NULL ,`tinhtrang`='1' WHERE `maimei`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getImei());
            result = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reset thanh cong imei san pham: "+ result);
            JDBCUtil.close(con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi reset imei san pham: " + ex.getMessage());
        }
        return result;
    }

    @Override
    public DTO_ChiTietSanPham selectById(String t) {
        DTO_ChiTietSanPham result = new DTO_ChiTietSanPham();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM ctsanpham WHERE maimei = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                String imei = rs.getString("maimei");
                int macauhinh = rs.getInt("phienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
                result = new DTO_ChiTietSanPham(imei, macauhinh, maphieunhap, maphieuxuat, tinhtrang);
            }
            JDBCUtil.close(con);
            JOptionPane.showMessageDialog(null, "Select thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi select: " + e.getMessage());
        }
        return result;
        
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<DTO_ChiTietSanPham> selectbyPb(int mapbsp) {
        ArrayList<DTO_ChiTietSanPham> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM ctsanpham where maphienbansp = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, mapbsp);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
                DTO_ChiTietSanPham ct = new DTO_ChiTietSanPham(imei, maphienban, maphieunhap, maphieuxuat, tinhtrang);
                result.add(ct);
            }
            JOptionPane.showMessageDialog(null, "Lay imei san pham thanh cong: " + result);
            JDBCUtil.close(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi lay imei san pham: " + e.getMessage());
        }
        return result;
    }
    
    public ArrayList<DTO_ChiTietSanPham> selectbyPhieuNhap(int mapn) {
        ArrayList<DTO_ChiTietSanPham> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM ctsanpham where maphieunhap = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, mapn);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
                DTO_ChiTietSanPham ct = new DTO_ChiTietSanPham(imei, maphienban, maphieunhap, maphieuxuat, tinhtrang);
                result.add(ct);
            }
            JOptionPane.showMessageDialog(null, "Lay imei san pham thanh cong: " + result);
            JDBCUtil.close(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi lay imei san pham: " + e.getMessage());
        }
        return result;
    }

    public ArrayList<DTO_ChiTietSanPham> getAllByMaPhieuNhapAndMaPBSP(int mapn, int mapbsp) {
        ArrayList<DTO_ChiTietSanPham> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM ctsanpham where maphieunhap = ? and maphienbansp = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, mapn);
            pst.setInt(2, mapbsp);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
                DTO_ChiTietSanPham ct = new DTO_ChiTietSanPham(imei, maphienban, maphieunhap, maphieuxuat, tinhtrang);
                result.add(ct);
            }
            JOptionPane.showMessageDialog(null, "Lay imei san pham thanh cong: " + result);
            JDBCUtil.close(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi lay imei san pham: " + e.getMessage());
        }
        return result;
    }
}
