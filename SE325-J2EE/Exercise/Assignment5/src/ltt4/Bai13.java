/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Admin
 */
public class Bai13 extends JFrame {

    String font = "";

    public Bai13() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Simple menu");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        JLabel statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 500);
        statusLabel.setText("Text");

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        JMenuBar menubar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenu editMenu = new JMenu("Edit");
        fileMenu.setMnemonic(KeyEvent.VK_E);

        // About
        JMenuItem eMenuItem1 = new JMenuItem("About");
        eMenuItem1.setMnemonic(KeyEvent.VK_A);
        eMenuItem1.setToolTipText("Author Vu Tuan Hai");

        // Exit
        JMenuItem eMenuItem2 = new JMenuItem("Exit");
        eMenuItem2.setMnemonic(KeyEvent.VK_E);
        eMenuItem2.setToolTipText("Exit application");
        eMenuItem2.addActionListener((event) -> System.exit(0));

        // Font
        final JRadioButton font1 = new JRadioButton("Serif");
        final JRadioButton font2 = new JRadioButton("Monospace");
        final JRadioButton font3 = new JRadioButton("DialogInput", true);

        font1.addItemListener((ItemEvent e) -> {
            font = "Serif";
            Font font4 = new Font("Serif", Font.PLAIN, 12);
            statusLabel.setFont(font4);
            statusLabel.setText("Text");
        });

        font2.addItemListener((ItemEvent e) -> {
            font = "Monospace";
            Font font4 = new Font("Monospace", Font.PLAIN, 12);
            statusLabel.setFont(font4);
            statusLabel.setText("Text");
        });

        font3.addItemListener((ItemEvent e) -> {
            font = "DialogInput";
            Font font4 = new Font("DialogInput", Font.PLAIN, 12);
            statusLabel.setFont(font4);
            statusLabel.setText("Text");
        });

        // Checkbox
        final JCheckBox ck1 = new JCheckBox("Bold");
        final JCheckBox ck2 = new JCheckBox("Italic");
        ck1.addActionListener((ActionEvent e) -> {

            if (ck2.isSelected()) {
                
                System.out.println("1");
                 Font font5=new Font(statusLabel.getFont().getName(),Font.ITALIC+Font.BOLD,statusLabel.getFont().getSize());
                statusLabel.setFont(font5);
                statusLabel.setText("Text");

            }
            Font font4 = new Font(font, Font.BOLD, 12);
            statusLabel.setFont(font4);
            statusLabel.setText("Text");
            

        });

        ck2.addActionListener((ActionEvent e) -> {
            if (ck1.isSelected()) {
                System.out.println("1");
                Font font5=new Font(statusLabel.getFont().getName(),Font.ITALIC+Font.BOLD,statusLabel.getFont().getSize());
                statusLabel.setFont(font5);
                statusLabel.setText("Text");

            }
            Font font4 = new Font(font, Font.ITALIC, 12);
            statusLabel.setFont(font4);
            statusLabel.setText("Text");
        });

        // Color
        final JButton btn_red = new JButton();
        btn_red.setBackground(Color.red);
        final JButton btn_green = new JButton();
        btn_green.setBackground(Color.green);
        final JButton btn_blue = new JButton();
        btn_blue.setBackground(Color.blue);

        btn_red.addActionListener(e -> {
            statusLabel.setForeground(Color.red);
        });

        btn_green.addActionListener(e -> {
            statusLabel.setForeground(Color.green);
        });
        btn_blue.addActionListener(e -> {
            statusLabel.setForeground(Color.blue);
        });

        ButtonGroup group = new ButtonGroup();
        group.add(font1);
        group.add(font2);
        group.add(font3);

        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        controlPanel3.add(ck1);
        controlPanel3.add(ck2);

        controlPanel.add(font1);
        controlPanel.add(font2);
        controlPanel.add(font3);

        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        controlPanel2.add(btn_blue);
        controlPanel2.add(btn_green);
        controlPanel2.add(btn_red);

        fileMenu.add(eMenuItem1);
        fileMenu.add(eMenuItem2);
        editMenu.add(controlPanel);
        editMenu.add(controlPanel3);
        editMenu.add(controlPanel2);
        menubar.add(fileMenu);
        menubar.add(editMenu);

        setJMenuBar(menubar);

        this.add(statusLabel);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Bai13 ex = new Bai13();
            ex.setVisible(true);
        });
    }
}
