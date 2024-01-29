https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low =0; int high = arr.length-1;

        while(low<=high)
        {
            int mid = (low+high)/2;
            int missing = arr[mid] -(mid+1);
            if(missing<k)   low = mid+1;
            else high = mid-1;
        }
        return low+k;
    }
}
// ans = arr[high] + more    [more = k-missing]
// ans  = arr[high] + k-missing
// ans  = arr[high] + k - (arr[high] -(high+1))
// ans  = k + high +1
// ans   = k + low