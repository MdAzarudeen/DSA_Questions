https://www.geeksforgeeks.org/problems/rotten-oranges2536/1?page=1&category=Graph&sortBy=submissions

//Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
//0 : Empty cell
//1 : Cells have fresh oranges
//2 : Cells have rotten oranges
//
//We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
//
//
//Example 1:
//
//Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
//Output: 1

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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// Time Complexity: O(N * M)
// Space Complexity: O(N * M)

class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time)
    {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution
{
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m=grid[0].length;
        int[][]vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int ctFresh=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i, j, 0));
                    vis[i][j]=2;
                }
                else
                {
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)
                    ctFresh++;
            }
        }

        int timeNeeded =0;
        int ct=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair curr = q.peek();
            int r = curr.row;
            int c= curr.col;
            int t=curr.time;

            timeNeeded= Math.max(timeNeeded, t);
            q.remove();
            for(int i=0; i<4; i++)
            {
                int nrow= drow[i]+r;
                int ncol= dcol[i]+c;
                if(nrow>=0  && nrow<n   && ncol>=0  && ncol<m
                        &&  vis[nrow][ncol]==0  &&grid[nrow][ncol]==1)
                {
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    ct++;
                }
            }
        }
        if(ctFresh!=ct) return -1;
        return timeNeeded;
    }
}