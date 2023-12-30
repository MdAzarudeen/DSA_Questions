//Given a string S. The task is to print all unique permutations of
//        the given string in lexicographically sorted order.
//
//        Example 1:
//
//        Input: ABC
//        Output:
//        ABC ACB BAC BCA CAB CBA
//        Explanation:
//        Given string ABC has permutations in 6
//        forms as ABC, ACB, BAC, BCA, CAB and CBA .


https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1?page=1&category=Backtracking&sortBy=submissions

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();

        }
        out.close();
    }
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> ans = new ArrayList<>();
        char[]c = S.toCharArray();
        perm(0,c,ans);
        Collections.sort(ans);
        return ans;
    }
    public void perm(int idx, char[]c, List<String>ans)
    {
        if(idx>=c.length)
        {
            String str = new String(c);
            if(!ans.contains(str))
                ans.add(str);
            return;
        }
        for(int i=0; i<c.length; i++)
        {
            swap(i,idx,c);
            perm(idx+1,c,ans);
            swap(i,idx,c);
        }
    }
    public void swap(int i, int idx, char[]c)
    {
        char temp= c[i];
        c[i]=c[idx];
        c[idx]=temp;
    }
}