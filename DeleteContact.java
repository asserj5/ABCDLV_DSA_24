package dsa.phonebook.abcdlv;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elliah Batista
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private node head;

    public void add(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean delete(int value) {
        if (head == null) {
            return false; // List is empty
        }
        if (head.data == value) {
            head = head.next; // Move head to the next node
            return true; // Deletion successful
        }
        node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next; // Bypass the node to delete
                return true; // Deletion successful
            }
            current = current.next;
        }
        return false; // Value not found
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        node current = head;
        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }
        result.append("");
        return result.toString();
    }
}

public class DeleteContact {
    private LinkedList list;
    private JTextField inputField;
    private JTextArea outputArea;

    public DeleteContact() {
        list = new LinkedList();
        JFrame frame = new JFrame("Linked List Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        inputField = new JTextField(10);
        JButton deleteButton = new JButton("Delete");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(inputField.getText());
                    if (list.delete(number)) {
                        outputArea.setText("Deleted " + number + list.display());
                    } else {
                        outputArea.setText("number " + number+ " not found" + list.display());
                    }
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    outputArea.setText("Please enter a valid integer.");
                }
            }
        });

        frame.add(new JLabel("Enter number to delete:"));
        frame.add(inputField);
        frame.add(deleteButton);
        frame.add(new JScrollPane(outputArea));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DeleteContact::new);
    }
}


    

