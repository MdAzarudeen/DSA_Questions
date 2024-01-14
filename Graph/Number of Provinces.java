https://www.geeksforgeeks.org/problems/number-of-provinces/1?page=2&category=Graph&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void dfs(int node, int n, int[]vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        for(int nbr=0; nbr<n; nbr++)
        {
            if(vis[nbr]!=1 && adj.get(node).get(nbr)==1)
            {
                dfs(nbr,n,vis,adj);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int n = adj.size();
        int []vis = new int[n];
        int ct=0;
        for(int i=0; i<n; i++)
        {
            if(vis[i]!=1)
            {
                dfs(i,n,vis,adj);
                ct++;
            }
        }
        return ct;
    }
}