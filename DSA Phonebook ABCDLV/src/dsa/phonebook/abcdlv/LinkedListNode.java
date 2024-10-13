/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa.phonebook.abcdlv;

/**
 *
 * @author Leon Riekert
 */
import java.util.LinkedList;
public class LinkedListNode {

    LinkedList<String[]> users = new LinkedList<>();
    String[] data;
    LinkedListNode next;
    static LinkedListNode head;
    
    
    //initialise node with data
    public LinkedListNode(String[] data) {
        this.data = data;
        this.next = null;
    }
    
    //Insert new node at first node
    public static void add(String[] data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (head == null) {
            head = newNode;
        }
        else
        {
            newNode.next = head;  //placing the new node into the 
            head = newNode;
        }
    }
    
    //goet the address of the head node
    public static LinkedListNode getHead(){
        return head;
    }
    
    
    
}
