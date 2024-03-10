/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_Product;
import DAO.DAO_RamList;
import DTO.DTO_Product;
import DTO.DTO_RamList;
import java.util.ArrayList;

/**
 *
 * @author Kiet
 */
public class BUS_RamList {
    public DAO_RamList ram = new DAO_RamList();
    private ArrayList<DTO_RamList> listRAM = new ArrayList<>();
    
    public BUS_RamList() {
        listRAM = ram.getAllData();
    }
    
    public ArrayList<DTO_RamList> getAllData() {
        return this.listRAM;
    }
}
