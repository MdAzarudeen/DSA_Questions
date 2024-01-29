https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();

            double res = new GFG().medianOfArrays(n, m, a, b);

            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }

    }
}
// } Driver Code Ends


//User function Template for Java

class GFG
{
    static double medianOfArrays(int n1, int n2, int a[], int b[])
    {
        if(n1>n2) return medianOfArrays(n2,n1,b,a);

        int left = (n1+n2+1)/2;
        int total = n1+n2;
        int low =0; int high = n1; //take the length of mini array as HIGH
        while(low<=high)
        {
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1<n1)      r1=a[mid1];
            if(mid2<n2)      r2=b[mid2];
            if(mid1-1>=0)   l1=a[mid1-1];
            if(mid2-1>=0)   l2=b[mid2-1];

            if(l1<=r2 && l2<=r1)
            {
                if(total%2==1)  return (double)Math.max(l2,l1);
                else    return  (double)((Math.max(l2,l1)+Math.min(r1,r2))/2.0);
            }else if(l1>r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0;
    }
}