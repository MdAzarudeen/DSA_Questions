https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
import java.util.*;

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


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Node []a = new Node[N];

            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();

                Node head = new Node(sc.nextInt());
                Node tail = head;

                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }

                a[i] = head;
            }

            Solution g = new Solution();

            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
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

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    Node merge(Node x, Node y)
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
    Node mergeKList(Node[]arr,int K)
    {
        int last = K-1;
        while(last!=0)
        {
            int i=0; int j = last;
            while(i<j)
            {
                arr[i]=merge(arr[i],arr[j]);
                i++;
                j--;
                if(i>=j)
                    last=j;
            }
        }
        return arr[0];
    }
}
