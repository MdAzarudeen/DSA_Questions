https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];

            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            int m=sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(a,n,m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //find the Mini(Max..number of pages)
    public static int findPages(int[]arr,int N,int M)
    {
        if(M>N) return -1;

        int low = findMax(arr);
        int high = findSum(arr);
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(func(arr,mid,M)==true)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
    public static boolean func(int[]arr, int pages, int students)
    {
        int noOfStd = 1; int pagesAdded = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(pagesAdded+arr[i]<=pages)
            {
                pagesAdded += arr[i];
            }else{
                noOfStd++;
                pagesAdded = arr[i];
            }
        }
        return noOfStd<=students;
    }
    public static int findMax(int[] arr)
    {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
            ans = Math.max(ans,arr[i]);
        return ans;
    }
    public static int findSum(int[] arr)
    {
        int ans = 0;
        for(int i=0; i<arr.length; i++)
            ans += arr[i];
        return ans;
    }
}