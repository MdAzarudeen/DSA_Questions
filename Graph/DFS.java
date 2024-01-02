https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?page=1&category=Graph&sortBy=submissions

//You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
//Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
//
//Example 1:
//Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
//Output: 0 2 4 3 1

//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> adj =
                    new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

// Tc:O(V + E), where V is the number of nodes and
//                 E is the number of edges .
// Sc: O(V)


class Solution {
    //  DFS traversal of the graph ---> follows recursion algo..
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[]vis = new boolean[V];
        dfsTraversal(0,vis,dfs,adj);
        return dfs;
    }

    public void dfsTraversal(int node, boolean[]vis, ArrayList<Integer> dfs,
                             ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=true;
        dfs.add(node);

        for(int nbr: adj.get(node))
        {
            if(vis[nbr]==false)
                dfsTraversal(nbr,vis,dfs,adj);
        }
    }
}