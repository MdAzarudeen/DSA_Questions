https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1?page=2&category=Graph&sortBy=submissions

//Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
//
//Example 1:
//
//Input:
//grid[][] = {{1, 1, 0, 0, 0},
//{1, 1, 0, 0, 0},
//{0, 0, 0, 1, 1},
//{0, 0, 0, 1, 1}}
//Output:
//1

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// Sc: O(N*M);
// Tc: O(N*M*log(N*M))+O(4*N*M);

// User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    void dfs(int row, int col, int[][]vis, int[][]grid, ArrayList<String>list, int R, int C)
    {
        vis[row][col]=1;
        list.add(toString(row-R,col-C));
        int n = grid.length;
        int m = grid[0].length;
        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};
        for(int i=0; i<4; i++)
        {
            int nrow= row+drow[i];
            int ncol= col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=1
                    &&grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,vis,grid,list,R,C);
            }
        }
    }
    String toString(int r , int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
