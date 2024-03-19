/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.DTO_NhaCungCap;
import java.util.ArrayList;

/**
 *
 * @author KIET
 */
public class BUS_NhaCungCap {
    private ArrayList<DTO_NhaCungCap> listNhaCungCap;
    private int nextMancc; // biến để lưu giá trị mancc của nhà cung cấp mới

    public BUS_NhaCungCap() {
        listNhaCungCap = new ArrayList<>();
        nextMancc = 1; // khởi tạo giá trị ban đầu cho mancc
    }

    public void themncc(String tenncc, String email, String diachi, String sodienthoai) {
        // Tăng giá trị của mancc lên 1 và gán cho nhà cung cấp mới
        int newMancc = nextMancc++;
        DTO_NhaCungCap ncc = new DTO_NhaCungCap(newMancc, tenncc, email, diachi, sodienthoai);
        listNhaCungCap.add(ncc);
    }

    // Phương thức xoá một nhà cung cấp
    public void xoancc(int index) {
        if (index >= 0 && index < listNhaCungCap.size()) {
            listNhaCungCap.remove(index);
        }
    }

    // Phương thức sửa thông tin của một nhà cung cấp
    public void suancc(int index, DTO_NhaCungCap ncc) {
        if (index >= 0 && index < listNhaCungCap.size()) {
            listNhaCungCap.set(index, ncc);
        }
    }

    // Lấy danh sách tất cả các nhà cung cấp
    public ArrayList<DTO_NhaCungCap> layTatCaNhaCungCap() {
        return listNhaCungCap;
    }
    
    
}
