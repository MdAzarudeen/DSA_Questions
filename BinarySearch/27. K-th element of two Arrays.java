https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];


            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }


            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));

        }
    }
}

// } Driver Code Ends


//Similar to find median of 2 sorted arrays


class Solution {
    public long kthElement( int a[], int b[], int n1, int n2, int k) {
        if(n1>n2) return kthElement(b,a,n2,n1,k);

        int left = k;
        int total = n1+n2;
        int low = Math.max(k-n2,0);
        int high = Math.min(k,n1); //take the length of mini array as HIGH
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
                return (long)Math.max(l2,l1);
            }else if(l1>r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0;

    }
}