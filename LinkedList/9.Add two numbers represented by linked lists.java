https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

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
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node reverse(Node head)
    {
        Node curr = head;
        Node prevNode = null;
        Node nextNode = null;
        while(curr!=null)
        {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        return prevNode;
    }
    static Node addTwoLists(Node first, Node second){
        Node t1 = reverse(first);
        Node t2 = reverse(second);
        Node dummy = new Node(-1);
        Node curr = dummy; int carry = 0;
        while(t1!=null || t2!=null)
        {
            int sum = carry;
            if(t1!=null)    sum = sum + t1.data;
            if(t2!=null)    sum = sum + t2.data;

            carry = sum/10;
            Node newNode = new Node(sum%10);
            curr.next = newNode;
            curr = curr.next;

            if(t1!=null)   t1=t1.next;
            if(t2!=null)     t2=t2.next;
        }
        if(carry!=0)
        {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        return reverse(dummy.next);
    }
}