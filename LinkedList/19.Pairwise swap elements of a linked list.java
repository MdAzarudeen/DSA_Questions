https://www.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1?page=2&category=Linked%20List&sortBy=submissions

//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

}
class GFG{
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data);
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data);
            }

            Node failure = new Node(-1);

            Solution g = new Solution();
            head = g.pairwiseSwap(head);

            Node temp = head;
            int f = 0;
            while (temp != null)
            {
                if(mp.get(temp) != temp.data){
                    f = 1;
                }
                temp = temp.next;
            }

            if(f==1){
                printList(failure);
            }
            else{
                printList(head);
            }
            t--;
        }
    }
}


// } Driver Code Ends


/* node class of the linked list

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

*/


class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        Node a = head; Node prev = null;
        Node b = null; Node c = null;
        while(a!=null && a.next!=null)
        {
            b=a.next;
            c=b.next;
            if(a==head)
            {
                head = b;
            }else{
                prev.next=b;
            }
            b.next=a;
            a.next=c;
            prev = a;
            a=c;
        }
        return head;
    }
}