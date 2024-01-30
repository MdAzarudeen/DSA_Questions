https://www.geeksforgeeks.org/problems/third-largest-element/1

//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.thirdLargest(arr,n));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    int thirdLargest(int a[], int n)
    {
        if(n<3) return -1;
        int largest = a[0];
        int secLargest = -1;
        int thirdLargest = Integer.MIN_VALUE;

        for(int i=1; i<n; i++)
        {
            if(a[i]>largest)
            {
                thirdLargest = secLargest;
                secLargest = largest;
                largest = a[i];
            }else if(a[i]<largest && a[i]>secLargest)
            {
                thirdLargest = secLargest;
                secLargest = a[i];
            }else if(a[i]<secLargest && a[i]>thirdLargest)
            {
                thirdLargest = a[i];
            }
        }
        return thirdLargest;
    }
}
