https://www.geeksforgeeks.org/problems/n-queen-problem0315/1?page=1&category=Backtracking&sortBy=submissions

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                board[i][j]='.';
        solve(0,board,res,list);
        return res;
    }
    static void solve(int col, char[][]board, ArrayList<ArrayList<Integer>>res,
                      ArrayList<Integer>temp)
    {
        if(col==board.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int row=0; row<board.length; row++)
        {
            if(validate(board,row,col)==true)
            {
                board[row][col]='Q';
                temp.add(row+1);
                solve(col+1,board,res,temp);
                board[row][col]='.';
                temp.remove(temp.size()-1);
            }
        }
    }
    static boolean validate(char[][]board, int row, int col)
    {
        //upper diagonal
        int duprow = row;
        int dupcol = col;
        while(row>=0 && col>=0)
        {
            if(board[row][col]=='Q')    return false;
            row--;
            col--;
        }
        // left side of row
        row = duprow;
        col = dupcol;
        while(col>=0)
        {
            if(board[row][col]=='Q')    return false;
            col--;
        }
        //lower diagonal
        row = duprow;
        col = dupcol;
        while(col>=0 && row<board.length)
        {
            if(board[row][col]=='Q')    return false;
            col--;
            row++;
        }
        return true;
    }
}