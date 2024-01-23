https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc=new Scanner(System.in);

        //taking total testcases
        int T=sc.nextInt();
        while(T-->0)
        {
            //creating an object of class Print
            Solution obj=new Solution();
            int N;

            //input N
            N=sc.nextInt();

            //calling printNos() methdo
            //of class Print
            obj.printNos(N);
            System.out.println();

        }

    }
}


// } Driver Code Ends


//User function Template for Java

// RECURSION METHOD

class Solution
{

    public void printNos(int N)
    {
        print(1,N);
    }
    public void print(int i, int n)
    {
        if(i>n)   return;
        System.out.print(i+" ");
        print(i+1,n);
    }
}

// BACKTRACK METHOD

class Solution
{

    public void printNos(int N)
    {
        print(N,N);
    }
    public void print(int i, int n)
    {
        if(i<1) return;
        print(i-1,n);
        System.out.print(i+" ");
    }
}