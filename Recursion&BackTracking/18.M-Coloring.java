https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int color[] = new int[n];
        return solve(graph,n,m,color,0);
    }
    public boolean solve(boolean graph[][], int n, int m, int[]color, int node)
    {
        if(node==n) return true;

        for(int i=1; i<=m; i++)
        {
            if(isSafe(graph,i,n,color,node)==true)
            {
                color[node]=i;

                if(solve(graph,n,m,color,node+1)==true)     return true;

                color[node]=0;
            }
        }
        return false;
    }
    public boolean isSafe(boolean graph[][], int c, int n, int[] color, int node)
    {
        for(int i=0; i<n; i++)
        {
            if(graph[node][i]==true && color[i]==c)
                return false;
        }
        return true;
    }
}