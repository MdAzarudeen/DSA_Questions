https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?page=1&category=Graph&sortBy=submissions

//Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
//
//Example 1:
//
//Input:
//V = 5, E = 5
//adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
//Output: 1

//
//TC: O(V+E) + O(V)
//        O(V+E)-> for BFS algo
//        O(V)-> for connected components
//SC: O(V)

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public boolean detectCycleByBFS(int src, int V, boolean[]vis,
                                    ArrayList<ArrayList<Integer>> adj)
    {
        vis[src]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        while(q.size()>0)
        {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(int nbr: adj.get(node))
            {
                if(vis[nbr]==false)
                {
                    vis[nbr]=true;
                    q.add(new Pair(nbr,node));
                }
                else if(parent!=nbr)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[]vis = new boolean[V];
        for(int i=0;i<V;i++)
            vis[i]=false;
        for(int i=0; i<V;i++)
        {
//  this for loop is used bcoz ->if we have connected components
            if(vis[i]==false)
            {
                if(detectCycleByBFS(i,V,vis,adj)==true)
                    return true;
            }
        }
        return false;
    }
}
