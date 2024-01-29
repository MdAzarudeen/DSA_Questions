https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a,k);
            System.out.printf("%.2f",ans);
            System.out.println();
        }
    }
}


// } Driver Code Ends


//More gas stations should be added inside the array bcoz if we add outside there is
//no change in minimal (max distance)

class Solution {
    public static double findSmallestMaxDist(int arr[],int K)
    {
        int n = arr.length;
        double low = 0;
        double high = 0;
        for(int i=0; i<n-1; i++)
            high = Math.max(high, (double)(arr[i+1]-arr[i]) );

        while((high-low)>1e-6)
        {
            double mid = (low+high)/2.0;
            int ct = noOfStationsRequired(arr,mid);

            if(ct>K)    low = mid;
            else high = mid;
        }
        return high;
    }
    public static int  noOfStationsRequired(int arr[], double dist)
    {
        int ct = 0;
        for(int i=1; i<arr.length; i++)
        {
            double numberInBetween = (arr[i]-arr[i-1])/dist;

            ct+= numberInBetween;
        }
        return ct;
    }
}
     