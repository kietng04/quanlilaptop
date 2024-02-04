/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_Product;
import DTO.DTO_Product;
import java.util.ArrayList;

/**
 *
 * @author Kiet
 */
public class BUS_Product {
    public DAO_Product product = new DAO_Product();
    private ArrayList<DTO_Product> listProduct = new ArrayList<>();
    
    public BUS_Product() {
        listProduct = product.getAllData();
    }
    
    public ArrayList<DTO_Product> getAllData() {
        return this.listProduct;
    }
}
