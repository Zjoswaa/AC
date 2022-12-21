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

    JLabel mat1Label = new JLabel("Material 1");
    JLabel mat2Label = new JLabel("Material 2");
    JLabel artifactPriceLabel = new JLabel("Artifact price");
    JLabel totalPriceLabel = new JLabel("Total cost");
    JLabel focusReturnRateLabel = new JLabel("Return rate (focus)");
    JLabel noFocusReturnRateLabel = new JLabel("Return rate (no focus)");
    JLabel sellPriceLabel = new JLabel("Sell price");
    JLabel xLabel1 = new JLabel("x");
    JLabel xLabel2 = new JLabel("x");
    JLabel percLabel1 = new JLabel("%");
    JLabel percLabel2 = new JLabel("%");

    JComboBox mat1Box = new JComboBox(materials);
    JComboBox mat2Box = new JComboBox(materials);

    JTextField artifactPriceField = new JTextField();
    JTextField totalPriceField = new JTextField();
    JTextField mat1AmountField = new JTextField();
    JTextField mat2AmountField = new JTextField();
    JTextField focusReturnRateField = new JTextField();
    JTextField noFocusReturnRateField = new JTextField();

    JRadioButton mat2RadioButton = new JRadioButton();
    JRadioButton artifactRadioButton = new JRadioButton();

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

        mat1Label.setBounds(10,10,111,30);
        mat1Label.setFont(defaultFont);
        calculatePanel.add(mat1Label);

        mat2Label.setBounds(10,60,111,30);
        mat2Label.setFont(defaultFont);
        calculatePanel.add(mat2Label);

        artifactPriceLabel.setBounds(10,110,141,30);
        artifactPriceLabel.setFont(defaultFont);
        calculatePanel.add(artifactPriceLabel);

        totalPriceLabel.setBounds(10,160,109,30);
        totalPriceLabel.setFont(defaultFont);
        calculatePanel.add(totalPriceLabel);

        focusReturnRateLabel.setBounds(10,210,209,30);
        focusReturnRateLabel.setFont(defaultFont);
        calculatePanel.add(focusReturnRateLabel);

        noFocusReturnRateLabel.setBounds(10,260,244,30);
        noFocusReturnRateLabel.setFont(defaultFont);
        calculatePanel.add(noFocusReturnRateLabel);

        sellPriceLabel.setBounds(10,310,105,30);
        sellPriceLabel.setFont(defaultFont);
        calculatePanel.add(sellPriceLabel);

        xLabel1.setBounds(300,8,11,30);
        xLabel1.setFont(defaultFont);
        calculatePanel.add(xLabel1);

        xLabel2.setBounds(300,58,11,30);
        xLabel2.setFont(defaultFont);
        calculatePanel.add(xLabel2);

        percLabel1.setBounds(347,210,30,30);
        percLabel1.setFont(defaultFont);
        calculatePanel.add(percLabel1);

        percLabel2.setBounds(347,260,30,30);
        percLabel2.setFont(defaultFont);
        calculatePanel.add(percLabel2);

        mat1Box.setSelectedIndex(-1);
        mat1Box.setBounds(180,10,112,30);
        mat1Box.setFont(defaultFont);
        calculatePanel.add(mat1Box);
        mat1Box.addActionListener(this);

        mat2Box.setSelectedIndex(-1);
        mat2Box.setBounds(180,60,112,30);
        mat2Box.setFont(defaultFont);
        mat2Box.setEnabled(false);
        calculatePanel.add(mat2Box);
        mat2Box.addActionListener(this);

        artifactPriceField.setBounds(180,110,190,30);
        artifactPriceField.setFont(defaultFont);
        artifactPriceField.setEnabled(false);
        calculatePanel.add(artifactPriceField);

        totalPriceField.setBounds(180,160,190,30);
        totalPriceField.setFont(defaultFont);
        totalPriceField.setEditable(false);
//        totalPriceField.setText("999999999");
        calculatePanel.add(totalPriceField);

        mat1AmountField.setBounds(319,10,50,31);
        mat1AmountField.setFont(defaultFont);
        calculatePanel.add(mat1AmountField);

        mat2AmountField.setBounds(319,60,50,31);
        mat2AmountField.setFont(defaultFont);
        mat2AmountField.setEnabled(false);
        calculatePanel.add(mat2AmountField);

        focusReturnRateField.setBounds(270,210,70,30);
        focusReturnRateField.setFont(defaultFont);
        calculatePanel.add(focusReturnRateField);

        noFocusReturnRateField.setBounds(270,260,70,30);
        noFocusReturnRateField.setFont(defaultFont);
        calculatePanel.add(noFocusReturnRateField);

        mat2RadioButton.setBounds(374,60,30,30);
        mat2RadioButton.setFont(defaultFont);
        mat2RadioButton.setEnabled(false);
        calculatePanel.add(mat2RadioButton);
        mat2RadioButton.addActionListener(this);

        artifactRadioButton.setBounds(374,110,30,30);
        artifactRadioButton.setFont(defaultFont);
        calculatePanel.add(artifactRadioButton);
        artifactRadioButton.addActionListener(this);
    }

    private void initResourcePanel() {
        resourcePanel.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mat2RadioButton) {
            if (mat2RadioButton.isSelected()) {
                mat2Box.setEnabled(true);
                mat2AmountField.setEnabled(true);
            } else {
                mat2Box.setSelectedIndex(-1);
                mat2Box.setEnabled(false);
                mat2AmountField.setText("");
                mat2AmountField.setEnabled(false);
            }
        } else if (e.getSource() == artifactRadioButton) {
            if (artifactRadioButton.isSelected()) {
                artifactPriceField.setEnabled(true);
            } else {
                artifactPriceField.setText("");
                artifactPriceField.setEnabled(false);
            }
        } else if (e.getSource() == mat1Box) {
            mat2RadioButton.setEnabled(true);
            mat2Box.removeAllItems();
            for (int i = 0; i < materials.length; i++) {
                if (i != mat1Box.getSelectedIndex()) {
                    mat2Box.addItem(materials[i]);
                }
            }
            mat2Box.setSelectedIndex(-1);
        }
    }
}
