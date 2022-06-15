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
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Bai8 extends JFrame {

    String tmp = "";
    File icon_file;

    Bai8() {
        JLabel label = new JLabel();
        
        JButton btn = new JButton("OPEN");
        add(btn, "North", 0);
        btn.addActionListener(e -> {

            JFileChooser file = new JFileChooser();

            int returnVal = file.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                icon_file = file.getSelectedFile();
                try {
                    label.setIcon(new ImageIcon(ImageIO.read(icon_file)));
                    
                } catch (IOException ex) {
                    Logger.getLogger(Bai8.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("File access cancelled by user.");
            }
             
        });

        label.setBounds(200, 200, 100, 100);
        label.setText("abc");
        add(label, "South", 1);

        setSize(400, 400);
        //setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Bai8();
    }
}
