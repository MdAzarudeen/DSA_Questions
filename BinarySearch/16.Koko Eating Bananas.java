https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int low = 1;
        int high = findMax(arr);
//Concept is she can eat bananas from 1 to max ele in array per hour
        int ans = Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int noOfHours = func(arr,mid);
            if(noOfHours<=h)
            {
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
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