https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?page=1&category=Graph&sortBy=submissions

// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
//
//Topo sort occurs in DAG graph (directed acyclic graph)
//topo sort should have elements equal to given elements which means no cycle
//if topo sort array has less elements than given elements, cycle is present

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[]indegree = new int[V];
        for(int i=0; i<V; i++)
        {
            for(int nbr: adj.get(i))
                indegree[nbr]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(indegree[i]==0)  q.add(i);
        }
        // int[]topo = new int[V];
        int ct=0;
        while(q.size()>0)
        {
            int node = q.peek();
            q.remove(); ct++;
            // topo[i++]=node;
            for(int nbr: adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0)
                    q.add(nbr);
            }
        }
        if(ct==V)   return false;
        return true;
    }
}