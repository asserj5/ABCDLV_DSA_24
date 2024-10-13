/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PhoneBook;

/**
 *
 * @author chane
 */

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchContact extends javax.swing.JFrame {

    // Declare GUI components as instance variables
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTable jTable1;

    public SearchContact() {
        initComponents(); // Initialize GUI components in the constructor
    }

    private void initComponents() {
        textField1 = new java.awt.TextField();
        textField2 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        jButton1 = new javax.swing.JButton("Search");
        jButton2 = new javax.swing.JButton("Exit");
        jButton3 = new javax.swing.JButton("Delete");
        jButton4 = new javax.swing.JButton("Insert");
        jButton5 = new javax.swing.JButton("Update");

        // Set up the table
        jTable1 = new javax.swing.JTable(new DefaultTableModel(new Object[][]{}, 
            new String[]{"Entry No.", "LastName", "Name", "Contact No", "Address"}));
        
        // Set up JScrollPane for the JTable
        JScrollPane jScrollPane1 = new JScrollPane(jTable1);

        // Layout setup
        setLayout(new FlowLayout());
        add(new JLabel("Name:"));
        add(textField1);
        add(new JLabel("Last Name:"));
        add(textField2);
        add(new JLabel("Number:"));
        add(textField3);
        add(jButton1);
        add(jScrollPane1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jButton5);

        // Set button actions
        jButton1.addActionListener(this::jButton1ActionPerformed);
        // Add actions for other buttons similarly...

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String lastname = textField2.getText().trim();
        String name = textField1.getText().trim();
        String number = textField3.getText().trim();
        
        List<String[]> foundContact = searchContactsInFile(lastname, name, number);
        
        if (!foundContact.isEmpty()) {
            displayContactsInTable(foundContact);
            JOptionPane.showMessageDialog(this, "Contacts found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No contacts found.", "Search Result", JOptionPane.WARNING_MESSAGE);
        }
    }

    private List<String[]> searchContactsInFile(String lastname, String name, String number) {
        List<String[]> foundContacts = new ArrayList<>();
        String filePath = "phoneBookInfo.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 4) {
                    String fileLastname = details[0].trim();
                    String fileName = details[1].trim();
                    String fileNumber = details[2].trim();
                    
                    boolean matches = true;
                    if (!lastname.isEmpty() && !fileLastname.equalsIgnoreCase(lastname)) {
                        matches = false;
                    }
                    if (!name.isEmpty() && !fileName.equalsIgnoreCase(name)) {
                        matches = false;
                    }
                    if (!number.isEmpty() && !fileNumber.equals(number)) {
                        matches = false;
                    }
                    
                    if (matches) {
                        foundContacts.add(details);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading from file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return foundContacts;
    }

    private void displayContactsInTable(List<String[]> contacts) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows
        int entryNo = 1;
        for (String[] contact : contacts) {
            model.addRow(new Object[]{entryNo++, contact[0], contact[1], contact[2], contact[3]});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            SearchContact SearchContact = new SearchContact();
            SearchContact.setVisible(true);
        });
    }
}

