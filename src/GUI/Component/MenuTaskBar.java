/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Component;

import DTO.AccountDTO;
import GUI.MainProgram;
import GUI.Menu.TrangChu;
import GUI.Menu.FormItems;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
    Color DefaultColor = new Color(135,206,235); //  DefaultColor: là màu xanh biển của menu nha
    Color HowerBackgroundColor = new Color(192,192,192);
    Color backgroundItemtaskbar = new Color(255,255,255);
    public boolean isSelected;
    JPanel pnlBottom, pnlHeader;
    
    TrangChu trangchu;
    String[][] listComponent = {
        {"Trang chủ", "home.svg", "trangchu"},
        {"Sản phẩm", "product.svg", "sanpham"},
        {"Phiếu nhập", "phieunhap.svg", "phieunhap"},
        {"Phiếu xuất", "phieuxuat.svg", "phieuxuat"},
        {"Khách hàng", "khachhang.svg", "khachhang"},
        {"Thống kê", "thongke.svg", "thongke"},
        {"Nhân viên", "nhanvien.svg", "nhanvien"},
        {"Nhà cung cấp", "nhacc.svg", "nhacungcap"},
        {"Tài khoản", "account.svg", "account"},
        {"Phân quyền", "phanquyen.svg", "sanpham"},
        {"Đăng xuất", "logout.svg", "sanpham"},
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
        pnlHeader = new JPanel();
//        pnlHeader.setPreferredSize(new Dimension(225, 120));
        pnlHeader.setPreferredSize(new Dimension(350, 150));
        pnlHeader.setBackground(DefaultColor);
        pnlHeader.setLayout(new FlowLayout(0, 0, 5));
        pnlHeader.setBorder(new EmptyBorder(5, 10, 0, 10));
        
        headerTaskbar header = new headerTaskbar("admin.svg", "    Xin chào " + user.getUsername() + "!");
        pnlHeader.add(header, BorderLayout.CENTER);
        this.add(pnlHeader, BorderLayout.NORTH);
        
        pnlCenter = new JPanel();
        pnlCenter.setPreferredSize(new Dimension(230, 300));
        pnlCenter.setLayout(new FlowLayout(0, 0, 5));
        pnlCenter.setBackground(DefaultColor);
        
        scrollPane = new JScrollPane(pnlCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(new EmptyBorder(5, 10, 0, 0));
        this.add(scrollPane, BorderLayout.CENTER);
        
        pnlBottom = new JPanel();
        pnlBottom.setPreferredSize(new Dimension(250, 50));
        pnlBottom.setBackground(DefaultColor);
        pnlBottom.setLayout(new BorderLayout(0, 0));
        this.add(pnlBottom, BorderLayout.SOUTH);
        
        for (int i = 0; i < listComponent.length; i++) {
            listitem[i] = new itemTaskbar(listComponent[i][1], listComponent[i][0]);
            pnlCenter.add(listitem[i]);
            if (i != 0) {
                 // nếu phân quyền không có ở listitem hiện tại thì không hiện
//              if (!checkRole(listComponent[i][2])) {
//                  listitem[i].setVisible(false);
//              }
             }
        }
        
        listitem[0].setBackground(HowerBackgroundColor);
        listitem[0].isSelected = true;
        
        for (int i = 0; i < listComponent.length; i++) {
            listitem[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    AddHover(evt);
                }
            });
        } 
        
        listitem[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                TrangChu a = new TrangChu();
                main.changePages(a);
            }
        });
        
        listitem[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                FormItems product = new FormItems();
                main.changePages(product);

            }
        });
        
        listitem[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                JPanel a = new JPanel(); // sau khi ông có class giao diện thì thay JPanel thành tên classs là được
                main.changePages(a);
            }
        });
       
    }

    public void AddHover(MouseEvent evt) {
        for (int i = 0; i < listitem.length; i++) {
            if (evt.getSource() == listitem[i]) {
                listitem[i].isSelected = true;
                listitem[i].setBackground(HowerBackgroundColor);

            } else {
                listitem[i].isSelected = false;
                listitem[i].setBackground(backgroundItemtaskbar);
            }
        }    
    }
}
