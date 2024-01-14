https://www.geeksforgeeks.org/problems/prerequisite-tasks/1?page=2&category=Graph&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int prerequisites[][] = new int[P][2];
            for(int i=0;i<P;i++)
            {
                for(int j=0;j<2;j++)
                {
                    prerequisites[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            if(ob.isPossible(N,P,prerequisites))
            {
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            t--;
        }
    }

}

// } Driver Code Ends

class Solution {
    public boolean isPossible(int V,int P, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<edges.length; i++)
        {
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[]indegree = new int[V];
        for(int i=0; i<V; i++)
        {
            for(int nbr: adj.get(i))
                indegree[nbr]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(q.size()>0)
        {
            int node = q.peek();
            q.remove();
            topo.add(node);
            for(int nbr: adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0)
                    q.add(nbr);
            }
        }
        if(topo.size()==V)     return true;
        return false;
    }

}