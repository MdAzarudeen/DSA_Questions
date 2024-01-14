https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1?page=1&category=Linked%20List&difficulty=Hard&sortBy=submissions

//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{

    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    static Node removeZeros(Node head)
    {
        Node curr = head;
        while(curr!=null && curr.data == 0){
            curr = curr.next;
        }
        return curr;
    }
    static int findCount(Node head)
    {
        int ct=0;
        Node temp = head;
        while(temp!=null)
        {
            ct++; temp=temp.next;
        }
        return ct;
    }
    static boolean getBiggerList(Node l1, Node l2)
    {
        int ct1 = findCount(l1);
        int ct2 = findCount(l2);
        if(ct1>ct2) return true;
        else if(ct1<ct2)    return false;

        Node head1= l1;
        Node head2= l2;
        while(head1!=null)
        {
            if(head1.data>head2.data)   return true;
            else if(head1.data<head2.data)  return false;

            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    static Node reverse(Node head)
    {
        Node curr = head;
        Node nextNode = null;
        Node prevNode = null;
        while(curr!=null)
        {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = curr.next;
        }
        return prevNode;
    }
    static Node subtract(Node l1, Node l2)
    {
        Node t1 = reverse(l1);
        Node t2 = reverse(l2);

        int  borrow = 0;
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(t1!=null)
        {
            int diff = borrow + t1.data - (t2!=null ? t2.data : 0);
            if(diff<0)
            {
                borrow = -1;
                diff = diff+10;
            }else{
                borrow = 0;
            }
            Node newNode = new Node(diff);
            curr.next = newNode;
            curr = curr.next;

            t1=t1.next;
            if(t2!=null)     t2=t2.next;
        }
        Node temp = dummy.next;
        dummy.next = null;
        temp = reverse(temp);
        temp = removeZeros(temp);

        return temp==null ? new Node(0) : temp;
    }
    static Node subLinkedList(Node l1, Node l2)
    {

        l1 = removeZeros(l1);
        l2 = removeZeros(l2);

        boolean check = getBiggerList(l1,l2);
        Node c1 = check ? l1 : l2;
        Node c2 = check ? l2 : l1;
        return subtract(c1,c2);
    }
}