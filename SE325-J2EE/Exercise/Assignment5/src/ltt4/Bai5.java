/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Bai5 extends JFrame {

    Bai5() {
        BorderLayout bl = new BorderLayout();

        JButton b1 = new JButton("1");
        b1.setBounds(100, 100, 100, 40);

        JButton b2 = new JButton("2");
        b2.setBounds(100, 100, 100, 40);

        JButton b3 = new JButton("3");
        b3.setBounds(100, 100, 100, 40);

        JButton b4 = new JButton("4");
        b4.setBounds(100, 100, 100, 40);

        JButton b5 = new JButton("5");
        b5.setBounds(100, 100, 100, 40);

        b1.addActionListener(e -> {
            b1.setVisible(false);
            b2.setVisible(true);
            b3.setVisible(true);
            b4.setVisible(true);
            b5.setVisible(true);
            
        });
        
        
        b2.addActionListener(e -> {
            b2.setVisible(false);
            b1.setVisible(true);
            b3.setVisible(true);
            b4.setVisible(true);
            b5.setVisible(true);
            
        });
        
        b3.addActionListener(e -> {
            b3.setVisible(false);
            b2.setVisible(true);
            b1.setVisible(true);
            b4.setVisible(true);
            b5.setVisible(true);
            
        });
        
        b4.addActionListener(e -> {
            b4.setVisible(false);
            b2.setVisible(true);
            b3.setVisible(true);
            b1.setVisible(true);
            b5.setVisible(true);
            
        });
        
        b5.addActionListener(e -> {
            b5.setVisible(false);
            b2.setVisible(true);
            b3.setVisible(true);
            b4.setVisible(true);
            b1.setVisible(true);
            
        });
        
        
        setLayout(new BorderLayout());
        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.SOUTH);
        add(b3, BorderLayout.CENTER);
        add(b4, BorderLayout.WEST);
        add(b5, BorderLayout.EAST);

        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Bai5();
    }
}
