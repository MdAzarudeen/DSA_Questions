https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1?page=1&category=Linked%20List&difficulty=Easy&sortBy=submissions

//{ Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
class Remove_Duplicate_From_LL
{
    Node head;
    Node tail;
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            GfG g = new GfG();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }}
// } Driver Code Ends


/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
        Node temp = head;
        while(temp!=null     &&     temp.next!=null)
        {
            Node nextNode = temp.next;
            while(nextNode!=null && nextNode.data==temp.data)
            {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            temp = temp.next;
        }
        return head;
    }
}
