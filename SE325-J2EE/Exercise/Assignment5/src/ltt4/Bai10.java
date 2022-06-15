/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai10 extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paint method

        this.setBackground(Color.WHITE);

        int[] xValues = { 20, 40, 50, 30, 20, 15 };
        int[] yValues = { 50, 50, 60, 80, 80, 60 };
        Polygon polygon1 = new Polygon( xValues, yValues, 6 );
        g.drawPolygon( polygon1 );
        g.fillPolygon(polygon1);
        
        g.setColor(Color.RED);
        g.drawLine(5, 30, 200, 30);

        g.setColor(Color.BLUE);
        g.drawRect(5, 40, 90, 55);
        g.fillRect(100, 40, 90, 55);

        g.setColor(Color.RED);
        g.drawLine(200, 60, 300, 10);
        g.drawLine(300, 10, 350, 50);
        
        g.setColor(Color.MAGENTA);
        g.drawOval(195, 100, 90, 55);
        g.fillOval(290, 100, 90, 55);

    }

    public static void main(String[] args) {
        // create frame for LinesRectsOvalsJPanel
        JFrame frame
                = new JFrame("Drawing lines, rectangles and ovals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Bai10 linesRectsOvalsJPanel = new Bai10();
        linesRectsOvalsJPanel.setBackground(Color.WHITE);
        frame.add(linesRectsOvalsJPanel); // add panel to frame
        frame.setSize(400, 210); // set frame size
        frame.setVisible(true); // display frame
    } // end main

}
