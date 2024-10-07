/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa.phonebook.abcdlv;

/**
 *
 * @author Leon Riekert
 */

import java.util.Map;
import java.util.HashMap;

public class AutoIncrementHashMap {
    private Map<Integer, String> phonebook;
    private int key;  //private key, only to be used in this class
    
    public AutoIncrementHashMap() 
    {
        phonebook = new HashMap<>();
        key = 1;
    }
    
    public void put(String value)
    {
        phonebook.put(key, value);
        ReadWriteFile info = new ReadWriteFile();
        info.fileWriter();
        key++;
    }
    
    public String get(int key)
    {
       return phonebook.get(key); 
    }
    
}
