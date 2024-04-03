/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.JDBCUtil;
import DTO.DTO_NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KIET
 */
public class DAO_NhanVien implements DAOInterface<DTO_NhanVien>{

    @Override
    public int insert(DTO_NhanVien t) {
     try{
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "INSERT INTO `nhanvien`(`manv`, `hoten`, `gioitinh`, `sdt`, `ngaysinh`, `trangthai`, `email`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getManv());
            pst.setString(2, t.getHoten());
            pst.setInt(3, t.getGioitinh());
            pst.setString(4, t.getSdt());
            pst.setDate(5, (java.sql.Date) t.getNgaysinh());
            pst.setString(6, t.getEmail());
            pst.setInt(7, t.getTrangthai());
            int result = pst.executeUpdate();
            JDBCUtil.close(con);
            return result;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Loi them nhan vien: " + e.getMessage());
            return -1;
     }
    }

    @Override
    public int update(DTO_NhanVien t) {
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "UPDATE `nhanvien` SET `hoten`=?,`gioitinh`=?,`sdt`=?,`ngaysinh`=?,`email`=?,`trangthai`=? WHERE `manv`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setInt(2, t.getGioitinh());
            pst.setString(3, t.getSdt());
            pst.setDate(4, (java.sql.Date) t.getNgaysinh());
            pst.setString(5, t.getEmail());
            pst.setInt(6, t.getTrangthai());
            pst.setInt(7, t.getManv());
            int result = pst.executeUpdate();
            JDBCUtil.close(con);
            return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi update nhan vien: " + e.getMessage());
            return -1;
        }

    }

    @Override
    public int delete(int t) {
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "DELETE FROM `nhanvien` WHERE `manv`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t);
            int result = pst.executeUpdate();
            JDBCUtil.close(con);
            return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi xoa nhan vien: " + e.getMessage());
            return -1;
        }
    
    }

    @Override
    public ArrayList<DTO_NhanVien> getAllData() {
        ArrayList<DTO_NhanVien> result = new ArrayList<DTO_NhanVien>();
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT * FROM `nhanvien`";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DTO_NhanVien nv = new DTO_NhanVien(rs.getInt("manv"), rs.getString("hoten"), rs.getInt("gioitinh"), rs.getString("sdt"), rs.getDate("ngaysinh"), rs.getInt("trangthai"), rs.getString("email"));
                result.add(nv);
            }
            JDBCUtil.close(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi lay nhan vien: " + e.getMessage());
        }
        return result;
        
    }

    @Override
    public DTO_NhanVien selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        
        try {
            Connection con = (Connection) JDBCUtil.getConnectDB();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlybanhang' AND TABLE_NAME = 'nhanvien'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("AUTO_INCREMENT");
            }
            JDBCUtil.close(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi lay AUTO_INCREMENT nhan vien: " + e.getMessage());
        }
        return -1;
    }
    
}
