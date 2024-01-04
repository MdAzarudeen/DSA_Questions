https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?page=1&category=Graph&sortBy=submissions

// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

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
    public boolean dfs(int src, int[]vis, int[]path, ArrayList<ArrayList<Integer>> adj)
    {
        vis[src]=1;
        path[src]=1;
        for(int nbr: adj.get(src))
        {
            if(vis[nbr]==0)
//            when node not visited
            {
                if(dfs(nbr,vis,path,adj)==true)
                    return true;
            }else if(path[nbr]==1)
//                previously visited node, has to be in same path
                return true;
        }
        path[src]=0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[]vis = new int[V];
        int[]path = new int[V];
        for(int i=0; i<V; i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,vis,path,adj)==true)
                    return true;
            }
        }
        return false;
    }
}