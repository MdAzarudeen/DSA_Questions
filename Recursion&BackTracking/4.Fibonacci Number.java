https://www.geeksforgeeks.org/problems/nth-fibonacci-number1335/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//Tc: O(2^n) bcoz bi-driectional recursion occurs

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        if(n<=1)    return n;

        int last = nthFibonacci(n-1);
        int secLast = nthFibonacci(n-2);

        return (last+secLast)%1000000007;
    }
}