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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ReadWriteFile {
    
    public void fileWriter(){
    try
    {
        BufferedWriter writeDetails = new BufferedWriter(new FileWriter("phoneBookInfo.txt", true)); //access the file and write information to it. The "true" allow the writing of now info without overwriting current info 
        //writeDetails.write("");
        writeDetails.close();  //close the file after writing to it
    }
    catch (IOException e)
    {
        JOptionPane.showMessageDialog(null, "Could not save data");
    }
    }
    
    public void fileReader(){
        try
        {
            BufferedReader readDetails = new BufferedReader(new FileReader("phoneBookInfo.txt"));
            System.out.println(readDetails.readLine());
            readDetails.close();  //close the file after reading it
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
