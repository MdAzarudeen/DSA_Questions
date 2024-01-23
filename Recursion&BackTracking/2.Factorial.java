https://www.geeksforgeeks.org/problems/factorial5739/1

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.factorial(N));
        }
    }
}
// } Driver Code Ends

//FUNCTIONAL RECURSION

class Solution{
    static long factorial(int N){
        if(N==0)    return 1;

        return N*factorial(N-1);
    }
}


//PARAMETRIZED RECURSION

class Solution{
    static long factorial(int N){
        if(N==0)    return 1;

        return fact(N-1,N);
    }
    static long fact(long i, long n)
    {
        if(i<1) return n;

        return fact(i-1,n*i);
    }
}
