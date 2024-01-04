https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1?page=1&category=Graph&sortBy=submissions

//Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.
//
//Note: An island is either surrounded by water or boundary of grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
//
//Example 1:
//
//Input:
//grid = {{0,1},{1,0},{1,1},{1,0}}
//Output:
//1

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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

SC: O(N*N);
        TC: O(N*N);


class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    // Function to find the number of islands.
    public void bfs(int row, int col, int[][]vis, char[][]grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));


        while(q.size()>0)
        {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for(int i=-1; i<=1; i++)
            {
                for(int j=-1; j<=1; j++)
                {
                    int nrow= r+i;
                    int ncol = c+j;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                            grid[nrow][ncol]=='1' && vis[nrow][ncol]!=1)
                    {
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]vis = new int[n][m];
        int ct=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(vis[i][j]!=1 && grid[i][j]=='1')
                {
                    bfs(i,j,vis,grid);
                    ct++;
                }
            }
        }
        return ct;
    }
}