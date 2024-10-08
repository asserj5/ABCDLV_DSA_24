/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa.phonebook.abcdlv;

import java.util.Arrays;

/**
 *
 * @author Leon Riekert
 */
public class LinkedListSorting {
    
    //selectionSorting
    LinkedListNode head = LinkedListNode.getHead();
    
    public void selectionSorting() {
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode minNode = current; 
            LinkedListNode prevMin = null;
            LinkedListNode pointer = current;
            while (pointer.next != null) {
                //if(pointer.next.data.compareToIgnoreCase(minNode.data)) {
                if(Alphabetical(pointer.next.data, minNode.data)) {  /////equals will not work, need smaller or equals///////
                    minNode = pointer.next;
                    prevMin = pointer;
                }
                pointer = pointer.next;
            }
                if(minNode != current) {
                    // data of current and minNode is swapped  
                    String[] temp = current.data;
                    current.data = minNode.data;
                    minNode.data = temp;
                }
                current = current.next;
        }
                
    }
    
    public boolean Alphabetical (String[] node1, String[] node2) {
        if (Arrays.equals(node1, node2)) {
            return false;
        } else {
            return node1[0].compareTo(node2[0]) < 0;   //////could require another part to comare the surnames as well.////
        }
    }
    
}
        

