https://www.geeksforgeeks.org/problems/subset-sums2234/1

import java.util.*;

class Solution {
    public ArrayList<Integer> SubsetSums(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(0,0,arr,arr.size(),ans);
        Collections.sort(ans);
        return ans;
    }
    public void solve(int idx, int sum, ArrayList<Integer> arr,
                      int n, ArrayList<Integer> ans)
    {
        if(idx==n)
        {
            ans.add(sum);
            return;
        }
        solve(idx+1,sum+arr.get(idx),arr,n,ans);
        solve(idx+1,sum,arr,n,ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
            arr.add(sc.nextInt());
        Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.SubsetSums(arr);
        Collections.sort(ans);
        for(int a : ans)
            System.out.print(a+" ");

    }
}