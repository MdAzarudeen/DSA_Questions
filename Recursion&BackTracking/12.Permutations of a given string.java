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
        List<String> ans = new ArrayList<>();
        char[] c = S.toCharArray();
        StringBuilder t = new StringBuilder();
        boolean[]freq = new boolean[c.length];
        solve(c,ans,t,freq);
        Collections.sort(ans);
        return ans;
    }
    public void solve(char[]c, List<String> ans, StringBuilder t, boolean[]freq)
    {
        if(t.length()==c.length)
        {
            String str = t.toString();
            if(!ans.contains(str))
            {ans.add(t.toString());
                return;}
        }

        for(int i=0; i<c.length; i++)
        {
            if(!freq[i])
            {
                freq[i]=true;
                t.append(c[i]);
                solve(c,ans,t,freq);
                t.deleteCharAt(t.length()-1);
                freq[i]=false;
            }
        }
    }
}