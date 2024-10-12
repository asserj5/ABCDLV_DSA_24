/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa.phonebook.abcdlv;

/**
 *
 * @author Vsat2
 */
  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Udpdate{

    // Main driver method
    public static void main(String[] args) {
        List<String> userDetail = new ArrayList<>();
        
        // Read user details from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("phoneBookInfo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userDetail.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Printing the original list of user details
        System.out.println("Original list: " + userDetail);
        
        Scanner sc = new Scanner(System.in);
        
        // Enter index to update
        System.out.print("Enter the index of the user detail to update: ");
        int index = sc.nextInt();
        sc.nextLine();  // Consume newline left-over
        if (index >= 0 && index < userDetail.size()) {
            System.out.print("Enter new user detail: ");
            String newDetail = sc.nextLine();
            // Updating the user detail at the specified index
            userDetail.set(index, newDetail);
        } else {
            System.out.println("Invalid index. Please run the program again.");
            sc.close();
            return;
        }

        // Printing the updated list of user details
        System.out.println("Updated list: " + userDetail);

        // Write updated details back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("phoneBookInfo.txt"))) {
            for (String detail : userDetail) {
                writer.write(detail);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        
    }
}

    
