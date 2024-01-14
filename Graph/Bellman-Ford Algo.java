https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?page=2&category=Graph&sortBy=submissions

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// Dijsktra algo does not occurs in negative weights
// hence, Bellman ford algo is used for negative weights.

// 2 imp points
// a)iterate till (n-1)times , so that distance array gets the exact minimum value
// b)do a separate iteration for (n-th)time to check negative cycle exists.


class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[]dist = new int[V];
        for(int i=0;i<V; i++)
            dist[i]=(int)1e8;
        dist[S]=0;

        // N-1 iterations for distance array
        for(int i=0; i<V-1; i++)
        {
            for(ArrayList<Integer> edge: edges)
            {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v])
                {
                    dist[v]=dist[u]+wt;
                }
            }
        }

        // Nth iteration to check negative cycle
        for(ArrayList<Integer> edge: edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v])
            {
                int[]temp = new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
}
