import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

public class Calculator {

    private JFrame mainFrame = new JFrame();

    private JLabel resultLabel = new JLabel();

    private JLabel memoryTextLabelData = new JLabel("0");
    private int activeFormula = 1;

    Calculator() {

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() * 480 / 1920;
        int height = gd.getDisplayMode().getHeight() * 400 / 1080;

        mainFrame.setSize(width, height);

        JButton buttonMemoryPlus = new JButton("M+");
        buttonMemoryPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double newValue = Double.parseDouble(resultLabel.getText())
                        + Double.parseDouble(memoryTextLabelData.getText());
                memoryTextLabelData.setText(newValue.toString());
            }
        });

        JButton buttonMemoryClear = new JButton("MC");
        buttonMemoryClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoryTextLabelData.setText("0");
            }
        });

        JRadioButton rbFormula1 = new JRadioButton("1");
        JRadioButton rbFormula2 = new JRadioButton("2");

        rbFormula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.this.activeFormula = 1;
            }
        });

        rbFormula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.this.activeFormula = 2;
            }
        });

        rbFormula1.setSelected(true);

        ButtonGroup formulaButtonGroup = new ButtonGroup();
        formulaButtonGroup.add(rbFormula1);
        formulaButtonGroup.add(rbFormula2);

        JTextField textVariableX = new JTextField("0", 6);
        JTextField textVariableY = new JTextField("0", 6);
        JTextField textVariableZ = new JTextField("0", 6);

        JButton buttonCalculate = new JButton("Calculate");

        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double result = null;
                double x = Double.parseDouble(textVariableX.getText());
                double y = Double.parseDouble(textVariableY.getText());
                double z = Double.parseDouble(textVariableZ.getText());
                switch (Calculator.this.activeFormula) {
                    case 1:
                        result = calculateFirstFormula(x, y, z);
                        break;
                    case 2:
                        result = calculateSecondFormula(x, y, z);
                        break;
                }

                Calculator.this.resultLabel.setText(result.toString());
            }
        });

        Box hboxFormulaChoice = Box.createHorizontalBox();
        hboxFormulaChoice.add(Box.createHorizontalGlue());
        hboxFormulaChoice.add(rbFormula1);
        hboxFormulaChoice.add(rbFormula2);
        hboxFormulaChoice.add(Box.createHorizontalGlue());

        Box hboxMemory = Box.createHorizontalBox();
        hboxMemory.add(Box.createHorizontalGlue());
        hboxMemory.add(buttonMemoryPlus);
        hboxMemory.add(buttonMemoryClear);
        hboxMemory.add(Box.createHorizontalStrut(20));
        hboxMemory.add(memoryTextLabelData);
        hboxMemory.add(Box.createHorizontalGlue());

        // Box hboxVariables = Box.createHorizontalBox();
        // hboxVariables.add(Box.createHorizontalStrut(width / 5));
        // Box hboxFunc = Box.createHorizontalBox();

        // JLabel labelForX = new JLabel("X:");
        // // JTextField textFieldX = new JTextField("0", 10);
        // // textFieldX.setMaximumSize(textFieldX.getPreferredSize());

        // JLabel labelForY = new JLabel("Y:");
        // // JTextField textFieldY = new JTextField("0", 10);
        // // textFieldY.setMaximumSize(textFieldY.getPreferredSize());

        // JLabel labelForZ = new JLabel("Z:");
        // // JTextField textFieldZ = new JTextField("0", 10);
        // // textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        // // Box hboxVariables = Box.createHorizontalBox();
        // hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
        // hboxVariables.add(Box.createHorizontalGlue());
        // hboxVariables.add(labelForX);
        // hboxVariables.add(Box.createHorizontalStrut(10));
        // hboxVariables.add(textVariableX);
        // hboxVariables.add(Box.createHorizontalStrut(100));
        // hboxVariables.add(labelForY);
        // hboxVariables.add(Box.createHorizontalStrut(10));
        // hboxVariables.add(textVariableY);
        // hboxVariables.add(Box.createHorizontalStrut(100));
        // hboxVariables.add(labelForZ);
        // hboxVariables.add(Box.createHorizontalStrut(10));
        // hboxVariables.add(textVariableZ);
        // hboxVariables.add(Box.createHorizontalGlue());

        // // JLabel labelForX = new JLabel("X:");

        // hboxVariables.add(labelForX);

        // hboxFunc.add(textVariableX);
        // hboxFunc.add(textVariableY);
        // hboxFunc.add(textVariableZ);
        // hboxFunc.setMaximumSize(new Dimension(30, 20));

        JLabel labelForX = new JLabel("X:");
        JTextField textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());

        JLabel labelForY = new JLabel("Y:");
        JTextField textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());

        JLabel labelForZ = new JLabel("Z:");
        JTextField textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));

        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalGlue()); // Добавить гибкость между textFieldX и textFieldY

        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalGlue()); // Добавить гибкость между textFieldY и textFieldZ

        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);


        JLabel labelForResult = new JLabel("Результат:");
        JTextField textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        // Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");

        // hboxVariables.add(hboxFunc);

        // Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(resultLabel);

        Box hboxCalculate = Box.createHorizontalBox();
        hboxCalculate.add(buttonCalculate);

        Box contentBox = Box.createVerticalBox();
        contentBox.add(hboxFormulaChoice);
        contentBox.add(hboxMemory);
        contentBox.add(hboxVariables);
        contentBox.add(hboxCalculate);

        contentBox.add(hboxResult);

        contentBox.add(Box.createVerticalGlue());

        mainFrame.getContentPane().add(contentBox);
    }

    private Double calculateFirstFormula(Double x, Double y, Double z) {

        return sqrt(
                Math.pow((Math.sin(y) + Math.pow(y, 2) + exp(Math.cos(y))), 2) +
                        Math.pow(Math.log(z * z) + Math.sin(3.14 * x * x), 3));
    }

    private Double calculateSecondFormula(Double x, Double y, Double z) {
        return sqrt(y) * (3 * Math.pow(z, x)) / sqrt(1 + Math.pow(y, 3));
    }

    public void setVisible(boolean state) {
        mainFrame.setVisible(state);
    }
}