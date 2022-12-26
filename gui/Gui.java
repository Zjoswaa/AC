package gui;

import calc.Calculator;
import static constants.Constants.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.Arrays;

public class Gui implements ActionListener {
    private final Calculator c = new Calculator();
    private final JFrame frame = new JFrame();

    // GUI parts
    private final JPanel calculatePanel = new JPanel();
    private final JPanel resourcePanel = new JPanel();

    JLabel mat1Label = new JLabel("Material 1");
    JLabel mat2Label = new JLabel("Material 2");
    JLabel artifactPriceLabel = new JLabel("Artifact price");
    JLabel totalCostLabel = new JLabel("Total cost");
    JLabel focusReturnRateLabel = new JLabel("Return rate (focus)");
    JLabel noFocusReturnRateLabel = new JLabel("Return rate (no focus)");
    JLabel sellPriceLabel = new JLabel("Sell price");
    JLabel xLabel1 = new JLabel("x");
    JLabel xLabel2 = new JLabel("x");
    JLabel percLabel1 = new JLabel("%");
    JLabel percLabel2 = new JLabel("%");
    JLabel arrowLabel1 = new JLabel("\u2192");
    JLabel arrowLabel2 = new JLabel("\u2192");
    JLabel profitLabel = new JLabel("Profit");

    JComboBox<String> mat1Box = new JComboBox<>(materials);
    JComboBox<String> mat2Box = new JComboBox<>(materials);
    JComboBox<String> loadFileBox = new JComboBox<>();

    JTextField artifactPriceField = new JTextField();
    JTextField totalCostField = new JTextField();
    JTextField mat1AmountField = new JTextField();
    JTextField mat2AmountField = new JTextField();
    JTextField focusReturnRateField = new JTextField();
    JTextField noFocusReturnRateField = new JTextField();
    JTextField sellPriceField = new JTextField();
    JTextField focusProfitField = new JTextField();
    JTextField noFocusProfitField = new JTextField();
    JTextField saveAsField = new JTextField();

    JRadioButton mat2RadioButton = new JRadioButton();
    JRadioButton artifactRadioButton = new JRadioButton();

    JButton calculateButton = new JButton("Calculate");
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");

    public Gui() {
        initFrame();
        initCalc();
        initTabbedpane();
        initResourcePanel();
        initCalculatePanel();
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
        tp.add("Crafting", calculatePanel);
        frame.add(tp);
    }

    private void initResourcePanel() {
        resourcePanel.setLayout(null);
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

        totalCostLabel.setBounds(10,160,109,30);
        totalCostLabel.setFont(defaultFont);
        calculatePanel.add(totalCostLabel);

        focusReturnRateLabel.setBounds(10,210,209,30);
        focusReturnRateLabel.setFont(defaultFont);
        calculatePanel.add(focusReturnRateLabel);

        noFocusReturnRateLabel.setBounds(10,260,244,30);
        noFocusReturnRateLabel.setFont(defaultFont);
        calculatePanel.add(noFocusReturnRateLabel);

        sellPriceLabel.setBounds(10,310,105,30);
        sellPriceLabel.setFont(defaultFont);
        calculatePanel.add(sellPriceLabel);

        xLabel1.setBounds(390,8,11,30);
        xLabel1.setFont(defaultFont);
        calculatePanel.add(xLabel1);

        xLabel2.setBounds(390,58,11,30);
        xLabel2.setFont(defaultFont);
        calculatePanel.add(xLabel2);

        percLabel1.setBounds(347,210,30,30);
        percLabel1.setFont(defaultFont);
        calculatePanel.add(percLabel1);

        percLabel2.setBounds(347,260,30,30);
        percLabel2.setFont(defaultFont);
        calculatePanel.add(percLabel2);

        arrowLabel1.setBounds(374,210,22,25);
        arrowLabel1.setFont(defaultFont);
        calculatePanel.add(arrowLabel1);

        arrowLabel2.setBounds(374,260,22,25);
        arrowLabel2.setFont(defaultFont);
        calculatePanel.add(arrowLabel2);

        profitLabel.setBounds(465,175,59,30);
        profitLabel.setFont(defaultFont);
        calculatePanel.add(profitLabel);

        mat1Box.setSelectedIndex(-1);
        mat1Box.setBounds(170,10,112,30);
        mat1Box.setFont(defaultFont);
        calculatePanel.add(mat1Box);
        mat1Box.addActionListener(this);

        mat2Box.setSelectedIndex(-1);
        mat2Box.setBounds(170,60,112,30);
        mat2Box.setFont(defaultFont);
        mat2Box.setEnabled(false);
        calculatePanel.add(mat2Box);
        mat2Box.addActionListener(this);

        loadFileBox.setBounds(500,60,170,31);
        loadFileBox.setFont(defaultFont);

        if (refreshSavedFiles()) {
            loadFileBox.setSelectedIndex(0);
        } else {
            loadFileBox.setSelectedIndex(-1);
        }
        calculatePanel.add(loadFileBox);
        loadFileBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                refreshSavedFiles();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        artifactPriceField.setBounds(170,110,190,31);
        artifactPriceField.setFont(defaultFont);
        artifactPriceField.setEnabled(false);
        calculatePanel.add(artifactPriceField);

        totalCostField.setBounds(170,160,190,31);
        totalCostField.setFont(defaultFont);
        totalCostField.setEditable(false);
//        totalPriceField.setText("999999999");
        calculatePanel.add(totalCostField);

        mat1AmountField.setBounds(409,10,50,31);
        mat1AmountField.setFont(defaultFont);
        calculatePanel.add(mat1AmountField);
        mat1AmountField.addActionListener(this);

        mat2AmountField.setBounds(409,60,50,31);
        mat2AmountField.setFont(defaultFont);
        mat2AmountField.setEnabled(false);
        calculatePanel.add(mat2AmountField);

        focusReturnRateField.setBounds(270,210,70,31);
        focusReturnRateField.setFont(defaultFont);
        calculatePanel.add(focusReturnRateField);

        noFocusReturnRateField.setBounds(270,260,70,31);
        noFocusReturnRateField.setFont(defaultFont);
        calculatePanel.add(noFocusReturnRateField);

        sellPriceField.setBounds(170,310,190,31);
        sellPriceField.setFont(defaultFont);
        sellPriceField.setEnabled(false);
        calculatePanel.add(sellPriceField);

        focusProfitField.setBounds(403,210,190,31);
        focusProfitField.setFont(defaultFont);
        focusProfitField.setEditable(false);
        calculatePanel.add(focusProfitField);

        noFocusProfitField.setBounds(403,260,190,31);
        noFocusProfitField.setFont(defaultFont);
        noFocusProfitField.setEditable(false);
        calculatePanel.add(noFocusProfitField);

        saveAsField.setBounds(500,10,170,31);
        saveAsField.setFont(defaultFont);
        saveAsField.setText("Save as");
        saveAsField.setHorizontalAlignment(JTextField.CENTER);
        saveAsField.setForeground(new Color(173,173,173));
        saveAsField.setSelectedTextColor(new Color(173,173,173));
        calculatePanel.add(saveAsField);
        saveAsField.addFocusListener(new FocusListener() {
            boolean wasEdited = false;
            @Override
            public void focusGained(FocusEvent e) {
                if (!wasEdited) {
                    wasEdited = true;
                    saveAsField.setText("");
                    saveAsField.setHorizontalAlignment(JTextField.LEFT);
                    saveAsField.setForeground(Color.BLACK);
                    saveAsField.setSelectedTextColor(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (saveAsField.getText().isEmpty()) {
                    wasEdited = false;
                    saveAsField.setText("Save as");
                    saveAsField.setHorizontalAlignment(JTextField.CENTER);
                    saveAsField.setForeground(new Color(173,173,173));
                    saveAsField.setSelectedTextColor(new Color(173,173,173));
                }
            }
        });

        mat2RadioButton.setBounds(464,60,30,30);
        mat2RadioButton.setFont(defaultFont);
        mat2RadioButton.setEnabled(false);
        calculatePanel.add(mat2RadioButton);
        mat2RadioButton.addActionListener(this);

        artifactRadioButton.setBounds(364,110,30,30);
        artifactRadioButton.setFont(defaultFont);
        calculatePanel.add(artifactRadioButton);
        artifactRadioButton.addActionListener(this);

        calculateButton.setBounds(10,360,150,50);
        calculateButton.setFont(defaultFont);
        calculatePanel.add(calculateButton);
        calculateButton.addActionListener(this);

        saveButton.setBounds(680,10,90,30);
        saveButton.setFont(defaultFont);
        calculatePanel.add(saveButton);
        saveButton.addActionListener(this);

        loadButton.setBounds(680,60,90,30);
        loadButton.setFont(defaultFont);
        calculatePanel.add(loadButton);
        loadButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            System.out.println("Calculate");
        } else if (e.getSource() == saveButton) {
            System.out.println("Save");
        } else if (e.getSource() == loadButton) {
            System.out.println("Load");
        } else if (e.getSource() == mat2RadioButton) {
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

    public boolean refreshSavedFiles() {
        // When box is clicked, search ACsaves dir for txt files and add the names to the box options
        loadFileBox.removeAllItems();
        File[] dirContents = new File(System.getProperty("user.dir") + "/ACsaves").listFiles();
        if (dirContents == null) {
            System.out.println("Error: ACsaves directory not found at " + System.getProperty("user.dir") + ", exiting.");
            System.exit(1);
        } else {
            if (dirContents.length == 0) {
                System.out.println("Saves dir is empty");
            } else {
                // Sort names alphabetically
                String[] dirContentNames = new String[dirContents.length];
                for (int i = 0; i < dirContents.length; i++) {
                    dirContentNames[i] = dirContents[i].getName();
                }
                Arrays.sort(dirContentNames);

                // Add to the box
                for (int j = 0; j < dirContentNames.length; j++) {
                    if (dirContentNames[j].endsWith(".txt")) {
                        // Don't include the ".txt" in added items
                        loadFileBox.addItem(dirContentNames[j].substring(0,dirContentNames[j].length() - 4));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
