https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1?page=1&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static long minTime(int[] arr,int n,int k)
    {
//Similar to Book Pages allocation problem
        int low = findMax(arr);
        int high = findSum(arr);
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(func(arr,mid,k)==true)
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
    static int findMax(int[]arr)
    {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
            ans = Math.max(ans,arr[i]);
        return ans;
    }
    static int findSum(int[]arr)
    {
        int ans =0;
        for(int i=0; i<arr.length; i++)
            ans += arr[i];
        return ans;
    }
}


