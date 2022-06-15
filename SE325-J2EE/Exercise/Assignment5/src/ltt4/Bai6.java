/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.util.Collections.list;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Bai6 extends JFrame{
    String tmp = "";
    Bai6() {
        String cato[] = {"văn học", "khoa học", "lịch sử", "công nghệ", "thể thao", "văn hóa"};
        JList<String> list = new JList(cato);
        
        //FlowLayout fl = new FlowLayout();
        //fl.setAlignment(FlowLayout.LEFT);
        //JPanel panel = new JPanel(fl);
        add(list, "North", 0);
        JTextField txt = new JTextField();
        
        add(txt, "South", 1);
        list.addListSelectionListener(e -> {
            tmp = list.getSelectedValue();
        });
        
        JButton btn = new JButton("Summit");
        btn.addActionListener(e -> {
            txt.setText(tmp);
        });
        
        add(btn, "West", 2);
        setSize(300, 400);
        //setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Bai6();
    }
}
