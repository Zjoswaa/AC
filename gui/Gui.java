package gui;

import javax.swing.*;

import calc.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static constants.Constants.*;

public class Gui implements ActionListener {
    private final Calculator c = new Calculator();
    private final JFrame frame = new JFrame();

    // Tabs for calculating and resource pricing
    private final JPanel calculatePanel = new JPanel();
    private final JPanel resourcePanel = new JPanel();

    public Gui() {
        initFrame();
        initCalc();
        initTabbedpane();
        initCalculatePanel();
        initResourcePanel();
    }

    private void initFrame() {
        frame.setSize(windowWidth, windowHeight);
        frame.setTitle(windowTitle);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(backgroundColor);
        frame.setVisible(true);
    }

    private void initCalc() {

    }

    private void initTabbedpane() {
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(0,0,windowWidth,windowHeight);
        tp.add("Resources", resourcePanel);
        tp.add("Calculator", calculatePanel);
        frame.add(tp);
    }

    private void initCalculatePanel() {
        calculatePanel.setLayout(null);

        JLabel mat1Label = new JLabel("Material 1");
        mat1Label.setBounds(10,10,111,30);
        mat1Label.setFont(defaultFont);
        calculatePanel.add(mat1Label);

        JLabel mat2Label = new JLabel("Material 2");
        mat2Label.setBounds(10,60,111,30);
        mat2Label.setFont(defaultFont);
        calculatePanel.add(mat2Label);

        JLabel artifactPriceLabel = new JLabel("Artifact price");
        artifactPriceLabel.setBounds(10,110,141,30);
        artifactPriceLabel.setFont(defaultFont);
        calculatePanel.add(artifactPriceLabel);

        JLabel totalPriceLabel = new JLabel("Total cost");
        totalPriceLabel.setBounds(10,160,109,30);
        totalPriceLabel.setFont(defaultFont);
        calculatePanel.add(totalPriceLabel);

        JLabel focusReturnRateLabel = new JLabel("Return rate (focus)");
        focusReturnRateLabel.setBounds(10,210,209,30);
        focusReturnRateLabel.setFont(defaultFont);
        calculatePanel.add(focusReturnRateLabel);

        JLabel noFocusReturnRateLabel = new JLabel("Return rate (no focus)");
        noFocusReturnRateLabel.setBounds(10,260,244,30);
        noFocusReturnRateLabel.setFont(defaultFont);
        calculatePanel.add(noFocusReturnRateLabel);

        JLabel sellPriceLabel = new JLabel("Sell price");
        sellPriceLabel.setBounds(10,310,105,30);
        sellPriceLabel.setFont(defaultFont);
        calculatePanel.add(sellPriceLabel);

        JComboBox mat1Box = new JComboBox(new String[]{"Wood","Bars","Cloth","Leather"});
        mat1Box.setSelectedIndex(-1);
        mat1Box.setBounds(180,10,112,30);
        mat1Box.setFont(defaultFont);
        calculatePanel.add(mat1Box);

        JComboBox mat2Box = new JComboBox(new String[]{"Wood","Bars","Cloth","Leather"});
        mat2Box.setSelectedIndex(-1);
        mat2Box.setBounds(180,60,112,30);
        mat2Box.setFont(defaultFont);
        calculatePanel.add(mat2Box);

        JTextField artifactPriceField = new JTextField();
        artifactPriceField.setBounds(180,110,131,30);
        artifactPriceField.setFont(defaultFont);
        calculatePanel.add(artifactPriceField);

        JTextField totalPriceField = new JTextField();
        totalPriceField.setBounds(180,160,131,30);
        totalPriceField.setFont(defaultFont);
        totalPriceField.setEditable(false);
        totalPriceField.setText("999999999");
        calculatePanel.add(totalPriceField);
    }

    private void initResourcePanel() {
        resourcePanel.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
