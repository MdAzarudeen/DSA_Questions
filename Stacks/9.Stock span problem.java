https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1?page=1&category=Stack&sortBy=submissions

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for(i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }



}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int arr[], int n)
    {
        int[] ngel = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(st.size()>0 && arr[st.peek()]<=arr[i])
                st.pop();

            if(st.size()>0) ngel[i]=i-st.peek();
            else ngel[i]=i+1;

            st.push(i);
        }
        return ngel;
    }

}
