https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

class Solution {
    public int minDays(int[] arr, int m, int k) {
        int n = arr.length;
        if((long)m*(long)k > n)     return -1;

        int ans = 0;
        int low = findMin(arr);
        int high = findMax(arr);
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(checkPossible(arr,mid,m,k)==true)
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
    public boolean checkPossible(int[]arr, int day, int m, int k)
    {
        int ct =0; int bouquets = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]<=day)     ct++;
            else
            {
                bouquets += (ct/k);
                ct = 0;
            }
        }
        bouquets += (ct/k);
        if(bouquets>=m) return true;
        return false;
    }
    public int findMin(int[] arr)
    {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++)
            ans = Math.min(ans,arr[i]);
        return ans;
    }
    public int findMax(int[] arr)
    {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
            ans = Math.max(ans,arr[i]);
        return ans;
    }
}