https://www.geeksforgeeks.org/problems/design-browser-history/1

//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        String homepage=bu.readLine();
        BrowserHistory obj=new BrowserHistory(homepage);
        int total_queries=Integer.parseInt(bu.readLine());
        while(total_queries-->0)
        {
            String s[]=bu.readLine().split(" ");
            int query=Integer.parseInt(s[0]);
            if(query == 1) {
                String url=s[1];
                obj.visit(url);
            }
            else if(query == 2) {
                int steps=Integer.parseInt(s[1]);
                System.out.println(obj.back(steps));
            }
            else {
                int steps=Integer.parseInt(s[1]);
                System.out.println(obj.forward(steps));
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Node{
    String data;
    Node next;
    Node prev;
    Node(String data){
        this.data =data;
        this.next = null;
        this.prev = null;
    }
}
class BrowserHistory {
    // constructor to initialize object with homepage
    Node currentPage = null;
    BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }

    // visit current url
    void visit(String url) {
        Node newNode = new Node(url);
        currentPage.next = newNode;
        newNode.prev = currentPage;
        currentPage = currentPage.next;
    }

    // 'steps' move backward in history and return current page
    String back(int steps) {
        while(steps>0)
        {
            if(currentPage.prev!=null)
                currentPage = currentPage.prev;
            else
                break;

            steps--;
        }
        return currentPage.data;
    }

    // 'steps' move forward and return current page
    String forward(int steps) {
        while(steps>0)
        {
            if(currentPage.next!=null)
                currentPage = currentPage.next;
            else
                break;

            steps--;
        }
        return currentPage.data;
    }
}