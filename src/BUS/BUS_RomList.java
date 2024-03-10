/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_RamList;
import DAO.DAO_RomList;
import DTO.DTO_RamList;
import DTO.DTO_RomList;
import java.util.ArrayList;

/**
 *
 * @author Kiet
 */
public class BUS_RomList {
    public DAO_RomList rom = new DAO_RomList();
    private ArrayList<DTO_RomList> listRom = new ArrayList<>();
    
    public BUS_RomList() {
        listRom = rom.getAllData();
    }
    
    public ArrayList<DTO_RomList> getAllData() {
        return this.listRom;
    }
}
