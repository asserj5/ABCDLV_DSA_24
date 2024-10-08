/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa.phonebook.abcdlv;

/**
 *
 * @author Leon Riekert
 */

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBookMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String[]> users = new LinkedList<>();
        
        String[] data = {"Asano", "Erica", "23", "Green Stone"};
        LinkedListNode.add(data);
        ReadWriteFile write = new ReadWriteFile();
        ReadWriteFile.fileWriter(data);
        
        //boolean endOfFile = false;
        //while (!endOfFile){
        ReadWriteFile info = new ReadWriteFile();
        info.fileReader();
        //endOfFile = true;
        //}
    
}
        
        
        
        /*Map<Integer, String> lastName = new HashMap<>();
            
        System.out.println(lastName.containsValue("Wick"));   //.getText from field. Call a different class/method to search content of the map??? Else implement a different search funtion
        lastName.put(1, "0811234567, John, Wick, Address");
        lastName.put(2, "Pines, Mable, 0814567893, Address");
        lastName.put(3, "0819873215, Kayle, Symes, Address");
        lastName.put(4, "Pines, Dipper, 0814567893, Address");
        lastName.put(4, "Pines, Stan, 0814567893, Address");
        lastName.put(5, "Stan, Will, 0814567893, Pine Street");
        
        System.out.println(lastName.values()); //only prints the info in the string
            
            System.out.println(lastName);  //includes postion/map number in the print
            
            String partialFind = "Pin";
            for (Map.Entry<Integer, String> entry : lastName.entrySet()) //enhanced for loop
            {
                if (entry.getValue().contains(partialFind))
                {
                    System.out.println(entry.getValue()); //case sensitive
                }
            }
            ReadWriteFile info = new ReadWriteFile();
            //info = "newFiles";
    }
    // load up all information from the text file  !!!!!!!!!!!!!!!!!!!!!!
    // create link list array 
    /*public void MapIncrement() {
        AutoIncrementingHashMap firstName = new AutoIncrementHashMap();
        
        
    }*/
    
}
