https://www.geeksforgeeks.org/problems/rotation4723/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        int low = 0; int high  = n-1;
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        while(low<=high)
        {
            // if the search space is already sorted
            if(arr[low]<=arr[high])
            {
                if(arr[low]<ans)
                {
                    ans = arr[low];
                    idx = low;
                }
                break;
            }
            int mid = (low+high)/2;
            //if left-half is sorted, take the mini and move to right half
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<ans)
                {
                    ans = arr[low];
                    idx = low;
                }
                low = mid+1;
            }
            //if right-half is sorted, take the mini and move to left half
            else
            {
                if(arr[mid]<ans)
                {
                    ans = arr[mid];
                    idx = mid;
                }
                high = mid-1;
            }
        }
        return idx;
    }
}