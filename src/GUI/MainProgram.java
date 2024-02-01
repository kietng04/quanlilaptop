/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.AccountDTO;
import GUI.Component.LeftMenu;
import GUI.Component.MenuTaskBar;
import GUI.Panel.TrangChu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import static org.apache.commons.math3.stat.StatUtils.mode; 

/**
 *
 * @author Kiet
 */
public class MainProgram extends JFrame {
    AccountDTO user;
    public JPanel MainContent;
    Color MainColor = new Color(230, 230, 230);
    Color white = new Color(230,230,230);
    private MenuTaskBar menuTaskbar;
    public MainProgram() {
        KhoiTao();
    }
    
    public MainProgram(AccountDTO acc) throws UnsupportedLookAndFeelException {
        this.user = acc;
        KhoiTao();
    }
    
    private void KhoiTao() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        DisplayMode mode = gd.getDisplayMode();
        int screenWidth = mode.getWidth();
        int screenHeight = mode.getHeight();
        this.setSize(screenWidth, screenHeight);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0, 0));
        this.setTitle("HỆ THỐNG QUẢN LÝ BÁN MÁY TÍNH");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuTaskbar = new MenuTaskBar(this, user);
        
        menuTaskbar.setPreferredSize(new Dimension(250, 1400));
        this.add(menuTaskbar, BorderLayout.WEST);
        MainContent = new JPanel();
        MainContent.setBackground(MainColor);
        MainContent.setLayout(new BorderLayout(0, 0));
        this.add(MainContent, BorderLayout.CENTER);
        
        TrangChu dashboard = new TrangChu();
        dashboard.setBackground(white);
        MainContent.add(dashboard); 
    }
    
    public void changePages(JPanel pn) {
        MainContent.removeAll();
        MainContent.add(pn);
        MainContent.repaint();
        MainContent.validate();
    }
    
}
