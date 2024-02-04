/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_Brand;
import DAO.DAO_Product;
import DTO.DTO_Brand;
import DTO.DTO_Product;
import java.util.ArrayList;

/**
 *
 * @author Kiet
 */
public class BUS_Brand {
    public DAO_Brand brand = new DAO_Brand();
    private ArrayList<DTO_Brand> listBrand = new ArrayList<>();
    
    public BUS_Brand() {
        listBrand = brand.getAllData();
    }
    
    public ArrayList<DTO_Brand> getAllData() {
        return this.listBrand;
    }
}
