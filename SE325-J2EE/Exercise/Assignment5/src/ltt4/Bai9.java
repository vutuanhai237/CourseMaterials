/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltt4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai9 {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public Bai9() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Bai9 swingControlDemo = new Bai9();
        swingControlDemo.showRadioButtonDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Bài 9");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        statusLabel.setText("Text");
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showRadioButtonDemo() {
        headerLabel.setText("Control in action: RadioButton");
        final JRadioButton radApple = new JRadioButton("Italic");
        final JRadioButton radMango = new JRadioButton("Bold");
        final JRadioButton radPeer = new JRadioButton("Italic & Bold");
        final JRadioButton radPeer2 = new JRadioButton("Regular", true);
        
        
        radApple.setMnemonic(KeyEvent.VK_C);
        radMango.setMnemonic(KeyEvent.VK_M);
        radPeer.setMnemonic(KeyEvent.VK_P);
        radApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Font font = new Font("Courier", Font.ITALIC,12);
                statusLabel.setFont(font);
                statusLabel.setText("Text");
            }
        });
        radMango.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Font font = new Font("Courier", Font.BOLD,12);
                statusLabel.setFont(font);
                statusLabel.setText("Text");
            }
        });
        radPeer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Font font = new Font("Courier", Font.BOLD + Font.ITALIC, 12);
                statusLabel.setFont(font);
                statusLabel.setText("Text");
            }
        });   
        
         radPeer2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Font font = new Font("Courier", Font.PLAIN, 12);
                statusLabel.setFont(font);
                statusLabel.setText("Text");
            }
        });   
        




        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(radApple);
        group.add(radMango);
        group.add(radPeer);
        group.add(radPeer2);
        
        controlPanel.add(radApple);
        controlPanel.add(radMango);
        controlPanel.add(radPeer);
        controlPanel.add(radPeer2);
        mainFrame.setVisible(true);
    }
}
