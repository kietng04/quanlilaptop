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

    public int getMaxIDHDH() {
        int maxhdh = 0;
       for (int i = 0; i < listHDH.size(); i++) {
           if (listHDH.get(i).getMahdh() > maxhdh) {
               maxhdh = listHDH.get(i).getMahdh();
           }
       }
       return maxhdh;
   }

   public int insert(DTO_HeDieuHanh t) {
       int result = hdh.insert(t);
       if (result == 1) {
           listHDH.add(t);
       }
       return result;
   }

   public DTO_HeDieuHanh getByID(int id) {
       for (DTO_HeDieuHanh dto : listHDH) {
           if (dto.getMahdh() == id) {
               return dto;
           }
       }
       return null;
   }
}
