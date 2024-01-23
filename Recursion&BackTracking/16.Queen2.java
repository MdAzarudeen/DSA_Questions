https://leetcode.com/problems/n-queens-ii/

class Solution {
    public int totalNQueens(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                board[i][j]='.';
        solve(0,board,res,list);
        return res.size();
    }
    public void solve(int col, char[][]board, ArrayList<ArrayList<Integer>>res,
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
    public boolean validate(char[][]board, int row, int col)
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