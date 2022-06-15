/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class Bai2 extends JFrame {

    public Bai2() {
        this.setSize(500, 200);
        this.setLocation(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lb = new JLabel("Nhập key: ");
        lb.setBounds(0, 0, 50, 50);
        this.add(lb, "North", 0);
      
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                String t = Character.toString(e.getKeyChar());
                lb.setText(t);
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
            }
        });
        
    }

    public static void main(String[] args) {
        Bai2 lt = new Bai2();
        lt.setVisible(true);
    }

}
