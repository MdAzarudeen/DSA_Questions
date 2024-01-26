https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        int low = 1; int high = m;
        while(low<=high)
        {
            int mid = (low+high)/2;

            int res = temp(n,m,mid);
            if(res==1)    return mid;
            else if(res==0) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    public int temp(int n, int m, int mid)
    {
//return 2 if ans>m; 1 if ans==m; 0 if ans<m
        long ans =1;
        for(int i=1; i<=n; i++)
        {
            ans = ans*mid;
            if(ans>m)   return 2;
        }
        if(ans==m)  return 1;
        return 0;
    }
}