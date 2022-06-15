/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.util.Collections.list;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Bai7 extends JFrame{
    String tmp = "";
    Bai7() {
        JColorChooser color = new JColorChooser();
        //FlowLayout fl = new FlowLayout();
        //fl.setAlignment(FlowLayout.LEFT);
        //JPanel panel = new JPanel(fl);
        
        color.setBounds(0, 0, 200, 100);
        add(color, "North", 0);
        
        
        
        JTextField txt = new JTextField();
        txt.setBounds(200, 200, 100, 100);
        add(txt, "South", 1);
        
        
        
        color.getSelectionModel().addChangeListener(e -> {
            Color NewColor = color.getColor();
            this.getContentPane().setBackground(NewColor);
            txt.setText(NewColor.toString());
        });
        
        setSize(400, 400);
        //setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Bai7();
    }
}
