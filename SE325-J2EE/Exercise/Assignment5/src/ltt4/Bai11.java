/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.*;
class Star {
    
    int x, y, width, height;

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Random rd = new Random();
        int xPoints[] = {9, 15, 0, 18, 3};
        int yPoints[] = {0, 18, 6, 6, 18};

        Graphics2D g2d = (Graphics2D) g;
        GeneralPath star = new GeneralPath();

        star.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 1; i < xPoints.length; i++) {
            star.lineTo(xPoints[i] + x, yPoints[i] + y);
        }
        star.closePath();
        Color c = new Color(rd.nextInt(256), rd.nextInt(256), rd.nextInt(256));
        
        g2d.setColor(c);
        g2d.fill(star);
    }
}
public class Bai11 extends JPanel {
    
    double alpha = 0;
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paint method
        
        this.setBackground(Color.WHITE);
        
        for (int i = 0; i < 20; i++)
        {
          
            double x = 200 + Math.cos(alpha) * 100;
            double y = 200 - Math.sin(alpha) * 100;
            Star s = new Star((int)x, (int)y);
            s.draw(g);
            alpha += 18;
        }
    }

    public static void main(String[] args) {
        // create frame for LinesRectsOvalsJPanel
        JFrame frame  = new JFrame("Draw start");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Bai11 linesRectsOvalsJPanel = new Bai11();
        linesRectsOvalsJPanel.setBackground(Color.WHITE);
        frame.add(linesRectsOvalsJPanel); // add panel to frame
        frame.setSize(400, 400); // set frame size
        frame.setVisible(true); // display frame
    } // end main

}
