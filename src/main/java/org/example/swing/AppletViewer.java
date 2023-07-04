package org.example.swing;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppletViewer extends JFrame {
    private JTextField enterField = new JTextField("Input BYN");
    private JTextField result = new JTextField();
    private static JComboBox comboBox = new JComboBox();
    private JButton convertButton = new JButton("Convert");


    static {
        comboBox.addItem("USD");
        comboBox.addItem("EUR");
        comboBox.addItem("RUB");


    }




    {
        convertButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (Integer.parseInt(enterField.getText()) > 0){
                        double currencyValue = Double.parseDouble(XMLCurrencyParser.getCurrency((String) comboBox.getSelectedItem()));
                        Thread.sleep(50);
                        double currencyResult = 0;
                        if (((String) comboBox.getSelectedItem()).equals("RUB")){
                            currencyResult = Integer.parseInt(enterField.getText()) / currencyValue * 100;
                        } else {
                            currencyResult = Integer.parseInt(enterField.getText()) / currencyValue;
                        }

                        result.setText((String.format("%,f2", currencyResult)));
                    }
                } catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Incorrect amount!");
                }
            }
        });
    }

    public AppletViewer(){
        setTitle("Applet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 400);
        setLayout(null);



        enterField.setBounds(100, 50, 100, 20);
        comboBox.setBounds(170, 150, 50, 20);
        convertButton.setBounds(100, 100, 100, 20);
        result.setBounds(50, 150, 100, 20);

        System.out.println(comboBox.getSelectedItem());



        add(enterField);
        add(comboBox);
        add(convertButton);
        add(result);



        setVisible(true);
    }
}

class Tester{
    public static void main(String[] args) {
        AppletViewer appletViewer = new AppletViewer();
    }
}
