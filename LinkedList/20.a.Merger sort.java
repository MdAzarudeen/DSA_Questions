https://www.geeksforgeeks.org/problems/sort-a-linked-list/1?page=2&category=Linked%20List&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{

    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            head = new Solution().mergeSort(head);
            printList(head);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
            return;

        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    static Node merge(Node x, Node y)
    {
        if(x==null) return y;
        if(y==null) return x;

        Node curr = null;
        if(x.data<=y.data)
        {
            curr = x;
            curr.next = merge(x.next,y);
        }else{
            curr = y;
            curr.next = merge(x,y.next);
        }
        return curr;
    }
    static Node middle(Node head)
    {
        Node fast = head;
        Node slow = head;
        Node prevSlow = null;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        return prevSlow;
    }
    static Node mergeSort(Node head)
    {
        if(head==null)  return null;
        if(head.next==null) return head;

        Node firstHalfTail = middle(head);
        Node secondHalfHead = firstHalfTail.next;
        firstHalfTail.next = null;

        head = mergeSort(head);
        secondHalfHead = mergeSort(secondHalfHead);
        return merge(head,secondHalfHead);
    }
}


