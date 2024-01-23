https://www.geeksforgeeks.org/problems/palindrome-string0817/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


class Solution {
    int isPalindrome(String S) {
        return check(S,0);
    }

    int check(String s, int i)
    {
        int n = s.length();
        if(i>=n/2)  return 1;

        if(s.charAt(i)!=s.charAt(n-1-i))    return 0;

        return check(s,i+1);
    }
}


class Solution {
    int isPalindrome(String S) {
        int n = S.length();
        return check(S,0,n-1);
    }
    int check(String s, int st, int ed)
    {
        if(st>=ed)  return 1;

        if(s.charAt(st)!=s.charAt(ed))  return 0;

        return check(s,st+1,ed-1);
    }

}