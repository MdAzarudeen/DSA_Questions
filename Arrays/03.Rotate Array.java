https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        //taking testcases
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String str=br.readLine();
            String[] starr=str.split(" ");

            //input n and d
            int n=Integer.parseInt(starr[0]);
            int d= Integer.parseInt(starr[1]);

            int[] arr=new int[n];
            String str1=br.readLine();
            String[] starr1=str1.split(" ");

            //inserting elements in the array
            for(int j=0;j<n;j++)
            {
                arr[j]= Integer.parseInt(starr1[j]);
            }

            //calling rotateArr() function
            new Solution().rotateArr(arr, d, n);
            StringBuffer sb=new StringBuffer();

            //printing the elements of the array
            for(int t1=0;t1<n;t1++)
                sb.append(arr[t1]+" ");
            out.println(sb);
        }
        out.close();
    }
}

// } Driver Code Ends


//other method -> we can create a temp array and first store the 'd' elements, then rotate the
// original array and add the temp elements.
// but this, will consume an extra space for array.
//hence, use reverse method

class Solution
{
    static void reverse(int arr[], int st, int ed)
    {
        while(st<=ed)
        {
            int temp = arr[st];
            arr[st]=arr[ed];
            arr[ed]=temp;
            st++; ed--;
        }
    }

    static void rotateArr(int arr[], int d, int n)
    {
        d=d%n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
}