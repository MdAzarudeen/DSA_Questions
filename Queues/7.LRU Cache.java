https://www.geeksforgeeks.org/problems/lru-cache/1?page=1&category=Queue&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node()
    {
        this.key=0;
        this.value=0;
        this.next=null;
        this.prev = null;
    }
    Node(int key, int value){
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
}
// design the class in the most optimal way

class LRUCache
{
    Node head;
    Node tail;
    int limit=0;
    HashMap<Integer,Node> cache;
    //Constructor for initializing the cache capacity with the given value.
    public LRUCache(int cap)
    {
        //code here
        head=new Node();
        tail=new Node();
        this.limit=cap;
        cache = new HashMap<>();

        head.next=tail;
        tail.prev=head;
    }
    public void addLast(Node node)
    {
        Node prevNode = tail.prev;
        node.prev=prevNode;
        prevNode.next=node;
        node.next=tail;
        tail.prev=node;
    }
    public  void removeNode(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        node.prev=null;
        node.next=null;
    }
    public void moveToLast(Node node)
    {
        removeNode(node);
        addLast(node);
    }

    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        // your code here
        if(cache.containsKey(key)==false)
        {
            return -1;
        }
        else
        {
            Node node = cache.get(key);
            moveToLast(node);
            return node.value;
        }
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        // your code here
        if(cache.containsKey(key)==false)
        {
            Node node = new Node(key,value);
            if(cache.size()==limit)
            {
                Node lru = head.next;
                removeNode(lru);
                cache.remove(lru.key);
            }
            addLast(node);
            cache.put(key,node);
        }
        else
        {
            Node node = cache.get(key);
            node.value=value;
            moveToLast(node);
        }
    }
}
