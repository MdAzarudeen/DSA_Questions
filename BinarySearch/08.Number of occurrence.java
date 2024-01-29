https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int fo = findFirst(arr,n,x);
        int lo = findLast(arr,n,x);
        if(fo==-1)
            return 0;
        else
            return lo-fo+1;
    }
    int findFirst(int arr[], int n, int x)
    {
        int fo = -1; int st =0; int ed = n-1;
        while(st<=ed)
        {
            int mid = (st+ed)/2;
            if(arr[mid]==x)
            {
                fo = mid;
                ed= mid-1;
            }else if(arr[mid]>x)    ed=mid-1;
            else st=mid+1;
        }
        return fo;
    }
    int findLast(int arr[], int n, int x)
    {
        int lo = -1; int st =0; int ed = n-1;
        while(st<=ed)
        {
            int mid = (st+ed)/2;
            if(arr[mid]==x)
            {
                lo = mid;
                st= mid+1;
            }else if(arr[mid]>x)    ed=mid-1;
            else st=mid+1;
        }
        return lo;
    }
}