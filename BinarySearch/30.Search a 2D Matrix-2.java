https://leetcode.com/problems/search-a-2d-matrix-ii/description/

class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int row = 0; int col = m-1;
        while(row<n && col>=0)
        {
            if(arr[row][col]==target)   return true;
            else if(arr[row][col]<target)   row++;
            else col--;
        }
        return false;
    }
}