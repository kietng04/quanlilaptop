/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.DTO_NhaCungCap;

import java.util.ArrayList;

import DAO.DAO_NhaCungCap;

/**
 *
 * @author KIET
 */
public class BUS_NhaCungCap {
    public DAO_NhaCungCap ncc = new DAO_NhaCungCap();

    public BUS_NhaCungCap() {

    }

    public ArrayList<DTO_NhaCungCap> getAllData() {
        return ncc.getAllData();
    }
    
    public void insert(DTO_NhaCungCap t) {
        ncc.insert(t);
    }

    public void update(DTO_NhaCungCap t) {
        ncc.update(t);
    }

    public void delete(int id) {
        ncc.delete(id);
    }
   
    

}
