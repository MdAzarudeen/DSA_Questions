https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?page=1&category=Graph&sortBy=submissions

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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public void dfs(int[][] image, int row, int col, int newColor,
                    int[][]ans, int initialColor)
    {
        ans[row][col]=newColor;
        int[]drow = {-1,0,1,0};
        int[]dcol = {0,1,0,-1};
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++)
        {
            int nrow= row+drow[i];
            int ncol= col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                    image[nrow][ncol]==initialColor &&
                    ans[nrow][ncol]!=newColor)
            {
                dfs(image,nrow,ncol,newColor,ans,initialColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int[][]ans = image;
        int initialColor = image[sr][sc];
        dfs(image,sr,sc,newColor,ans,initialColor);
        return ans;
    }
}