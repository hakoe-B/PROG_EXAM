/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productapp;

/**
 *
 * @author Student
 */

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;

public class ProductApp extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cboProduct;
    private JTextField txtPrice;
    private JMenuItem mnuExit, mnuProcess, mnuClear;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Q.2.4 - Menu System
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");
        mnuExit = new JMenuItem("Exit");
        mnuProcess = new JMenuItem("Process");
        mnuClear = new JMenuItem("Clear");
        fileMenu.add(mnuExit);
        toolsMenu.add(mnuProcess);
        toolsMenu.add(mnuClear);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(20, 20, 130, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 20, 200, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(20, 60, 130, 25);
        add(lblProduct);

        cboProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        });
        cboProduct.setBounds(160, 60, 200, 25);
        add(cboProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(20, 100, 130, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 100, 200, 25);
        add(txtPrice);

        // Q.2.4 - Exit closes app
        mnuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Q.2.4 - Process calls same logic as Process button
        mnuProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });

        // Q.2.4 - Clear clears text boxes and resets combo to 0
        mnuClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCustomerName.setText("");
                txtPrice.setText("");
                cboProduct.setSelectedIndex(0);
            }
        });
    }

    private void processSale() {
        try {
            String customer = txtCustomerName.getText();
            String product = (String) cboProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Q.2.5 - Use the class, NOT manual calculation
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + customer + "\n"
                    + "Product: " + product + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            String data = "DATA LOG\n"
                    + "************************************\n"
                    + "Customer Name: " + customer + "\n"
                    + "Product: " + product + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + total + "\n"
                    + "************************************";

            FileWriter writer = new FileWriter("data.txt");
            writer.write(data);
            writer.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price");
        }
    }

    public static void main(String[] args) {
        new ProductApp().setVisible(true);
    }
}