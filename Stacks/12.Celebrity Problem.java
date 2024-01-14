https://www.geeksforgeeks.org/problems/the-celebrity-problem/1?page=1&category=Stack&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    int celebrity(int M[][], int n)
    {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++)
            st.push(i);
        while(st.size()>1)
        {
            int p1 = st.pop();
            int p2 = st.pop();

            if(M[p1][p2]==1)
                st.push(p2);
            else
                st.push(p1);
        }

        int celeb = st.pop();

        for(int i=0; i<n; i++)
        {
            if(i!=celeb && M[celeb][i]!=0)   return -1;
        }
        for(int i=0; i<n; i++)
        {
            if(i!=celeb && M[i][celeb]!=1)   return -1;
        }
        return celeb;
    }
}