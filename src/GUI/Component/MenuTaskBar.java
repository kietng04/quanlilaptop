/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Component;

import DTO.AccountDTO;
import GUI.MainProgram;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Kiet
 */
public class MenuTaskBar extends JPanel {
    MainProgram main;
    AccountDTO user;
    
    Color DefaultColor = new Color(135,206,235);
    
    String[][] listComponent = {
        {"Trang chủ", "home.svg", "trangchu"},
        {"Sản phẩm", "product.svg", "sanpham"},
        {"Phiếu nhập", "phieunhap.svg", "phieunhap"},
        {"Phiếu xuất", "phieuxuat.svg", "phieuxuat"},
        {"Khách hàng", "khachhang.svg", "khachhang"},
        {"Thống kê", "thongke.svg", "thongke"},
        {"Nhân viên", "nhanvien.svg", "nhanvien"},
        {"Sản phẩm", "product.svg", "sanpham"},
    };
    
    public itemTaskbar[] listitem;
    JPanel mainContainer, pnlCenter;
    JScrollPane scrollPane;
    
    public MenuTaskBar(MainProgram main, AccountDTO tk) {
        this.main = main;
        this.user = tk;
        KhoiTaoLeftMenu();
    }
    
    public void KhoiTaoLeftMenu() {
        listitem = new itemTaskbar[listComponent.length];
        this.setBackground(DefaultColor);
        this.setLayout(new BorderLayout(0, 0));
        
        pnlCenter = new JPanel();
        pnlCenter.setPreferredSize(new Dimension(230, 600));
        pnlCenter.setBackground(DefaultColor);
        pnlCenter.setLayout(new FlowLayout(0, 0, 5));
        
        scrollPane = new JScrollPane(pnlCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(new EmptyBorder(5, 10, 0, 10));
        this.add(scrollPane, BorderLayout.CENTER);
        
        for (int i = 0; i < listComponent.length; i++) {
            if (i + 1 == listComponent.length) {
//                listitem[i] = new itemTaskbar(listComponent[i][1], listComponent[i][0]);
//                pnlBottom.add(listitem[i]);
            } else {
                listitem[i] = new itemTaskbar(listComponent[i][1], listComponent[i][0]);
                pnlCenter.add(listitem[i]);
                if (i != 0) {
                    // nếu phân quyền không có ở listitem hiện tại thì không hiện
//                    if (!checkRole(listComponent[i][2])) {
//                        listitem[i].setVisible(false);
//                    }
                }
            }
        }
        
        mainContainer = new JPanel();
        mainContainer.setPreferredSize(new Dimension(50, 80));
        mainContainer.setBackground(DefaultColor);
        mainContainer.setLayout(new BorderLayout(0, 0));
        this.add(mainContainer, BorderLayout.NORTH);
    }
}
