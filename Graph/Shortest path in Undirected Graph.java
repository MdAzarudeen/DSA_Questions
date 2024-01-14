https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {

    public int[] shortestPath(int[][] edges,int V,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<m; i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[]dist = new int[V];
        for(int i=0; i<V; i++)
            dist[i]=(int)1e9;
        dist[src]=0;
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        while(q.size()>0)
        {
            int node = q.peek();
            q.remove();
            for(int nbr: adj.get(node))
            {
                if(dist[node]+1<dist[nbr])
                {
                    dist[nbr]=dist[node]+1;
                    q.add(nbr);
                }
            }
        }
        for(int i=0; i<V; i++)
        {
            if(dist[i]==(int)1e9)
                dist[i]=-1;
        }
        return dist;
    }
}