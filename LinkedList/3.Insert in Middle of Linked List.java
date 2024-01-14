https://www.geeksforgeeks.org/problems/insert-in-middle-of-linked-list/1?page=2&category=Linked%20List&sortBy=submissions

//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=0; i<n-1; i++){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            int key = sc.nextInt();

            //display(head);
            Solution obj = new Solution();
            obj.insertInMid(head, key);
            display(head);
            System.out.println();
        }
    }

    public static void display(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {

    public Node insertInMid(Node head, int data){
        int ct =0;
        Node temp = head;
        while(temp!=null)
        {
            ct++;
            temp = temp.next;
        }
        int pos = ct/2;
        Node curr = head;
        if(ct%2==0)    pos--; //for even list
        while(pos>0)
        {
            curr = curr.next;
            pos--;
        }
        Node abs = curr.next;
        Node newNode = new Node(data);
        curr.next = newNode;
        newNode.next = abs;
        return head;
    }
}