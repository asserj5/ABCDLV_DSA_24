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
        LinkedListNode current = head;     // set current node to the head node 
        while (current != null) {
            LinkedListNode minNode = current;     //the lowesst node in the sense of the aphlabet
            LinkedListNode prevMin = null;
            LinkedListNode pointer = current;
            while (pointer.next != null) {     // the while loop will keep iterting until the end of the linked list where th last node will have a null in the next pointer.
                
                if(Alphabetical(pointer.next.data, minNode.data)) {  //compare next node data to that of the current node
                    minNode = pointer.next;
                    prevMin = pointer;
                }
                pointer = pointer.next;
            }
                if(minNode != current) {                       
                    String[] temp = current.data;    // create a temporary array to store the data of the current node
                    current.data = minNode.data;    // data of current and minNode is swapped
                    minNode.data = temp;    // data of current and minNode is swapped
                }
                current = current.next;    //set current variable to that of the following node.
        }
                
    }
    
    public boolean Alphabetical (String[] node1, String[] node2) {   //compare the first part of the array of both nodes.  //could require another part to comare the surnames as well, as this only sorts for the first part wich is the name.
        if (Arrays.equals(node1, node2)) {
            return false;
        } else {
            return node1[0].compareTo(node2[0]) < 0;   
        }
    }
    
}
        

