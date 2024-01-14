https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?page=1&category=Stack&sortBy=submissions

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            long n = Long.parseLong(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[(int)n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            System.out.println(new Solution().getMaxArea(arr, n));
        }
    }
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n)
    {
        long[] nseli = left(hist,n);
        long[] nseri = right(hist,n);
        long maxArea = 0L;
        for(long i=0; i<n; i++)
        {
            long area= (nseri[i]-nseli[i]-(int)1)*hist[i];
            maxArea= Math.max(area, maxArea);
        }
        return maxArea;
    }
    public static long[] left(long hist[], long n)
    {
        long[] nseli = new long[n];
        Stack<Long> st = new Stack<>();
        for(long i=0; i<n; i++)
        {
            while(st.size()>0   && hist[st.peek()]>=hist[i])
                st.pop();

            if(st.size()>0) nseli[i]=st.peek();
            else    nseli[i]=-1;

            st.push(i);
        }
        return nseli;
    }
    public static long[] right(long hist[], long n)
    {
        long[] nseri = new long[n];
        Stack<Long> st = new Stack<>();
        for(long i=n-1; i>=0; i--)
        {
            while(st.size()>0   && hist[st.peek()]>=hist[i])
                st.pop();

            if(st.size()>0) nseri[i]=st.peek();
            else    nseri[i]=n;

            st.push(i);
        }
        return nseri;
    }

}



