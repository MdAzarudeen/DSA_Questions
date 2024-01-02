https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1?page=1&category=Greedy&sortBy=submissions
//
//Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
//Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
//
//
//Example 1:
//
//Input: n = 6
//arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
//dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
//Output: 3
//Explanation:
//Minimum 3 platforms are required to
//safely arrive and depart all trains.

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);

            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }


}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.


//     Tc: O(2N log N)+O(2N);
//    N log N for sorting, 2 is for sorting two arrays
// 2N is for two pointers
    Sc: O(1)- no external space is used
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int firstTrain = 1;
        int secondTrain = 0;
        int platform = 1; int ans = 1;
        while(firstTrain<n  && secondTrain<n)
        {
            if(arr[firstTrain]<=dep[secondTrain])
            {
                platform++;
                firstTrain++;
            }
            else if(arr[firstTrain]>dep[secondTrain])
            {
                platform--;
                secondTrain++;
            }
            if(platform>ans)
                ans=platform;
        }
        return ans;
    }
}

