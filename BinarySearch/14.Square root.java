https://www.geeksforgeeks.org/problems/square-root/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends

//sqrt --> Max no which on squaring is less than X


class Solution
{
    long floorSqrt(long x)
    {
        long low =0; long high = x;
        while(low<=high)
        {
            long mid = (low+high)/2;
            if(mid*mid<=x)
            {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
}
