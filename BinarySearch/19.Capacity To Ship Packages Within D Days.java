https://www.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1?page=2&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        int low = findMax(arr); //to take each weights in each day
        int high = findSum(arr); //to take all weights in one day
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(func(arr,mid)<=D)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
    static int func(int[]arr, int cap)
    {
        int days=1; int load = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(load+arr[i]>cap)
            {
                days = days + 1;
                load = arr[i];
            }else
                load = load + arr[i];
        }
        return days;
    }
    static int findMax(int[] arr)
    {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
            ans = Math.max(ans,arr[i]);
        return ans;
    }
    static int findSum(int[] arr)
    {
        int ans = 0;
        for(int i=0; i<arr.length; i++)
            ans += arr[i];
        return ans;
    }
}