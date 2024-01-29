https://leetcode.com/problems/find-a-peak-element-ii/description/

class Solution {
    public int[] findPeakGrid(int[][] arr) {
        int[] ans = new int[2];
        int n = arr.length;
        int m = arr[0].length;
        int low = 0; int high = m-1;
        while(low<=high)
        {
            int mid = (low+high)/2; //take mid as required column
            int row = findMaxRow(arr,n,mid);

            int left = mid-1>=0 ? arr[row][mid-1] : -1;
            int right = mid+1<m ? arr[row][mid+1] : -1;

            if(arr[row][mid]> left && arr[row][mid]>right)
            {
                ans[0]=row; ans[1]=mid;
                return ans;
            }else if(arr[row][mid]<left)    high = mid-1;
            else low = mid+1;
        }
        return ans;
    }
    public int findMaxRow(int[][]arr, int n, int col)
    {
        int ans = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<n; i++)
        {
            if(arr[i][col]>ans)
            {
                ans = arr[i][col];
                idx = i;
            }
        }
        return idx;
    }
}
