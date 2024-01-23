https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.checkSubsequenceSum(n,a,k);
            System.out.println(ans?"Yes":"No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static List<List<Integer>> ans = new ArrayList<>();
    public static boolean checkSubsequenceSum(int N, int[] nums, int K) {
        return solve(nums,new ArrayList<>(), 0,K,0,N);
    }
    public static boolean solve(int[]nums, ArrayList<Integer> temp, int st, int k, int sum, int n)
    {
        if(st==n)
        {
            if(sum==k)
            {
                ans.add(new ArrayList<>(temp));
                return true;
            }else
                return false;

        }
        // pick
        temp.add(nums[st]);
        sum += nums[st];
        if(solve(nums,temp,st+1,k,sum,n)==true)
            return true;
        // not pick
        sum -= nums[st];
        temp.remove(temp.size()-1);
        if(solve(nums,temp,st+1,k,sum,n)==true)
            return true;

        return false;
    }
}
