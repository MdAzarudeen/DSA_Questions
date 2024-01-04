//Linear graph with no cycle -> Bipartite
// Any graph with even cycle length -> Bipartite
//Any graph with odd cycle length ->Not Bipartite

https://www.geeksforgeeks.org/problems/bipartite-graph/1?page=1&category=Graph&sortBy=submission
// Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}
// } Driver Code Ends


// Tc:O(V + E), where V is the number of nodes (while loop) and
//                 E is the number of edges (for loop).
// Sc: O(V)

class Solution
{
    public boolean bfs (int node, int V, int[]vis, ArrayList<ArrayList<Integer>>adj)
    {
        vis[node]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(q.size()>0)
        {
            int parent = q.peek();
            q.remove();
            for(int nbr: adj.get(parent))
            {
                if(vis[nbr]==-1)
                {
                    vis[nbr]=1-vis[parent];
                    q.add(nbr);
                }
                else if(vis[nbr]==vis[parent])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[]vis = new int[V];
        for(int i=0; i<V; i++)   vis[i]=-1;

        for(int i=0; i<V; i++)
        {
            if(vis[i]==-1)
            {
                if(bfs(i,V,vis,adj)==false)
                    return false;
            }
        }
        return true;
    }
}