https://leetcode.com/problems/n-queens/description/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                board[i][j]='.';
        solve(0,board,res);
        return res;
    }
    public void solve(int col, char[][]board,List<List<String>>res)
    {
        if(col==board.length)
        {
            res.add(construct(board));
            return;
        }
        for(int row=0; row<board.length; row++)
        {
            if(validate(board,row,col)==true)
            {
                board[row][col]='Q';
                solve(col+1,board,res);
                board[row][col]='.';
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
    public List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}