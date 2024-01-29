https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1?page=2&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String St[] = read.readLine().split(" ");

            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);

            String S[] = read.readLine().split(" ");

            int[] arr = new int[N];

            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K)
    {
//Similar to Book Pages allocation problem
        int low = findMax(arr);
        int high = findSum(arr);
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(func(arr,mid,K)==true)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
    static boolean func(int[]arr, int sum, int subArrayCt)
    {
        int noOfSubArrays = 1; int sumAdded = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(sumAdded+arr[i]<=sum)
            {
                sumAdded += arr[i];
            }else{
                noOfSubArrays++;
                sumAdded = arr[i];
            }
        }
        return noOfSubArrays<=subArrayCt;
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