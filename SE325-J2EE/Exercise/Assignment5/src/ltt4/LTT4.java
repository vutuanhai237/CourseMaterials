/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.Button;
import java.awt.Dimension;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Admin
 */
public class LTT4 extends JFrame {

    public LTT4() {
        this.setSize(500, 200);
        this.setLocation(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lb = new JLabel("Nhập tên: ");
        lb.setBounds(0, 0, 50, 50);
        this.add(lb, "North", 0);
        JTextField txt_name = new JTextField(); 
        txt_name.setBounds(0, 0, 50, 50);
        this.add(txt_name, "Center", 1);
        
        JButton btn = new JButton("HELLO");
        btn.setSize(50, 50);
        btn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Xin chao " + txt_name.getText(), "Messsage", JOptionPane.OK_OPTION);
        });
        
        this.add(btn, "South", 1);
    }

    public static void main(String[] args) {
        LTT4 lt = new LTT4();
        lt.setVisible(true);
    }

}
