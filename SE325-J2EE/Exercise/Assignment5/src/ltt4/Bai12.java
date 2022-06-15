/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Admin
 */
public class Bai12 {
    public static void main(String[] args) {
      JFrame frame = createFrame();
      JSlider slider = createSlider();
      CirclePanel circlePanel = new CirclePanel();
      slider.addChangeListener(changeEvent -> {
          JSlider s = (JSlider) changeEvent.getSource();
          circlePanel.setRadius(s.getValue());
      });
      frame.add(slider, BorderLayout.NORTH);
      frame.add(circlePanel);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
  }

  private static JSlider createSlider() {
      JSlider slider = new JSlider();
      slider.setMaximum(100);
      slider.setValue(50);
      slider.setMajorTickSpacing(10);
      slider.setMinorTickSpacing(5);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      return slider;
  }

  private static JFrame createFrame() {
      JFrame frame = new JFrame("JSlider Basic example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(400, 300));
      return frame;
  }
}
class CirclePanel extends JPanel {
  private int radius = 50;

  public CirclePanel() {
      setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
  }

  public void setRadius(int radius) {
      this.radius = radius;
      repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.pink);
      g.fillOval(getWidth() / 2 - radius,
              getHeight() / 2 - radius,
              2 * radius, 2 * radius);
  }
}