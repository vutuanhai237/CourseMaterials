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
public class Bai4 extends JFrame{

    Bai4() {
        FlowLayout fl = new FlowLayout();
        
        JPanel panel = new JPanel(fl);

        JButton l = new JButton("Left");
        l.setBounds(100, 100, 100, 40);

        JButton c = new JButton("Center");
        c.setBounds(100, 100, 100, 40);

        JButton r = new JButton("Right");
        r.setBounds(100, 100, 100, 40);

        panel.add(l);
        panel.add(c);
        panel.add(r);

        l.addActionListener(e -> {
            fl.setAlignment(FlowLayout.LEFT);
           
        });
        //fl.setAlignment(FlowLayout.RIGHT);
        setSize(300, 400);
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Bai4();
    }
}
