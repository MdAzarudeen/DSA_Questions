https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1?page=1&category=Queue&sortBy=submissions

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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String a)
    {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<a.length(); i++ )
        {
            char ch = a.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(map.get(ch)==1)
                q.add(ch);

            while(!q.isEmpty() && map.get(q.peek())>1)
            {
                q.remove();
            }
            if(q.isEmpty())
                ans.append('#');
            else
                ans.append(q.peek());
        }
        return ans.toString();
    }
}