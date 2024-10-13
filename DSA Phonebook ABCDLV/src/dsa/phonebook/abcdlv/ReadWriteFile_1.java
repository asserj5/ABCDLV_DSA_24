/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa.phonebook.abcdlv;

/**
 *
 * @author Leon Riekert
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class ReadWriteFile_1 {
    
    public static void fileWriter(String data[]/*LinkedList<?> users, String writeToFile*/){
    try
    {
        BufferedWriter writeDetails = new BufferedWriter(new FileWriter("phoneBookInfo.txt", true)); //access the file and write information to it. The "true" allow the writing of now info without overwriting current info 
        
       LinkedListNode current = LinkedListNode.getHead();  
        
            
        for (int i = 0; i < current.data.length; i++ ){ 
            if (i <= 2) {
                writeDetails.write(current.data[i] + ",");   //write the first three data parts and seperate then with a comma
            }
            else
            {
                writeDetails.write(current.data[i] + "\n");    //ensure data writes to a new line every time after the last data is added
            }
        
        }
        
        writeDetails.close();  //close the file after writing to it
    }
    catch (IOException e)
    {
        JOptionPane.showMessageDialog(null, "Could not save data");  //
    }
    }
    
    public static void fileReader(){
        try
        {
            BufferedReader readDetails = new BufferedReader(new FileReader("phoneBookInfo.txt"));   
            String line;
            while ((line = readDetails.readLine()) != null)  //read from the file as until the end of the document
            {
            System.out.println(line);
            }
            readDetails.close();  //close the file after reading it
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
