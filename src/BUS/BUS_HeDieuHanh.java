/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_HeDieuHanh;
import DTO.DTO_HeDieuHanh;
import java.util.ArrayList;

/**
 *
 * @author Kiet
 */
public class BUS_HeDieuHanh {
    public DAO_HeDieuHanh hdh = new DAO_HeDieuHanh();
    private ArrayList<DTO_HeDieuHanh> listHDH = new ArrayList<>();
    
    public BUS_HeDieuHanh() {
        listHDH = hdh.getAllData();
    }
    
    public ArrayList<DTO_HeDieuHanh> getAllData() {
        return this.listHDH;
    }
}
