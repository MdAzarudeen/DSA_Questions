https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1?page=1&category=Linked%20List&sortBy=submissions

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

            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


//function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution
{
    Node reverseList(Node head)
    {
        Node curr = head;
        Node prevNode = null;
        Node nextNode = null;
        while(curr!=null)
        {
            nextNode = curr.next;
            curr.next = prevNode;    //actual changing Link
            prevNode = curr;
            curr = nextNode;
        }
        return prevNode;
    }
}
