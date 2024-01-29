https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

class Solution {
    public int smallestDivisor(int[] arr, int tar) {
        int low = 1;
        int high = findMax(arr);
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(func(arr,mid)<=tar)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
    public int findMax(int[] arr)
    {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
            ans = Math.max(ans,arr[i]);
        return ans;
    }
    public int func(int[]arr, int n)
    {
        int res = 0;
        for(int i=0; i<arr.length; i++)
        {
            res += Math.ceil((double)arr[i]/(double)n);
        }
        return res;
    }
}