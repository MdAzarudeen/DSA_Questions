https://www.geeksforgeeks.org/problems/alien-dictionary/1?page=1&category=Graph&sortBy=submissions

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for(int i=0;i<n;i++)
            {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words,n,k);
            if(order.length() == 0){
                System.out.println(0);
                continue;
            }
            String temp[] = new String[n];
            for(int i=0;i<n;i++)
                temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>(){

                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length())
                            && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if(index1 == index2 && a.length() != b.length())
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if(index1 < index2)
                        return -1;
                    else
                        return 1;

                }
            });

            int flag = 1;
            for(int i=0;i<n;i++)
            {
                if(!words[i].equals(temp[i]))
                {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }

}

// } Driver Code Ends


//Order is not possible
// eg-> (abcd, abc)comparing these two, will not give any difference
// eg->(abc,bat,ade)a<b<a cycle forms, no order possible

class Solution
{
    public ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj,int V)
    {
        int[]indegree = new int[V];
        for(int i=0; i<V; i++)
        {
            for(int nbr: adj.get(i))
                indegree[nbr]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(q.size()>0)
        {
            int node = q.peek();
            q.remove();
            ans.add(node);
            for(int nbr: adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0)
                    q.add(nbr);
            }
        }
        return ans;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++)
            adj.add(new ArrayList<>());

        for(int i=0; i<N-1; i++)
        {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int j=0; j<len; j++)
            {
                if(s1.charAt(j)!=s2.charAt(j))
                {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        ArrayList<Integer> ans = topoSort(adj,K);

        String res="";
        for(int x: ans)
        {
            res += (char)(x+'a');
        }
        return res;
    }
}