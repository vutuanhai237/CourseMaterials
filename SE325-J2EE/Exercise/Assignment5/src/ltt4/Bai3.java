/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;

import java.awt.Container;

/**
 *
 * @author Admin
 */
public class Bai3 extends JFrame {

    private JButton leftJButton;
    private JButton centerJButton;
    private JButton rightJButton;
    private FlowLayout layout;
    private Container container;

    public Bai3() {
        super("FlowLayout Demo");

        layout = new FlowLayout();
        container = getContentPane();
        setLayout(layout);

        leftJButton = new JButton("Left");
        add(leftJButton);
        leftJButton.addActionListener(e -> {
            layout.setAlignment(FlowLayout.LEFT);

            layout.layoutContainer(container);
        }
        );

        centerJButton = new JButton("Center");
        add(centerJButton); // add Center button to frame
        centerJButton.addActionListener(e -> {
            layout.setAlignment(FlowLayout.CENTER);

            layout.layoutContainer(container);
        });

        rightJButton = new JButton("Right");
        add(rightJButton);
        rightJButton.addActionListener(e -> {
            layout.setAlignment(FlowLayout.RIGHT);

            layout.layoutContainer(container);
        });
    }
    public static void main( String[] args )
    { 
      Bai3 flowLayoutFrame = new Bai3(); 
      flowLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      flowLayoutFrame.setSize( 300, 75 ); // set frame size
      flowLayoutFrame.setVisible( true ); // display frame
   } // end main
}
