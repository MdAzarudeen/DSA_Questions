https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

//{ Driver Code Starts
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            String a[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            long x = Long.parseLong(a[(int)1]);
            String st[] = read.readLine().trim().split("\\s+");

            long arr[] = new long[n];
            for(int i = 0; i < n; i++)
            {
                arr[i] = Long.parseLong(st[i]);
            }

            out.println(new Solution().findFloor(arr, n, x));

        }
        out.close();
    }

}
// } Driver Code Ends

//Floor in an array --> largest no in array <= X

//Ceil in an array --> smallest no in array >=X (lower bound algo)


class Solution{
    static int findFloor(long arr[], int n, long x)
    {
        int low = 0; int high = n-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(arr[mid]<=x)
            {
                ans = mid;
                low = mid+1;
            }else
            {
                high = mid-1;
            }
        }
        return ans;
    }

}
