https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates,0,target,ans,new ArrayList<>());
        return ans;
    }
    public void solve(int[]arr, int idx, int tar, List<List<Integer>>ans,
                      List<Integer> temp)
    {
        if(idx==arr.length)
        {
            if(tar==0   &&  !ans.contains(temp))
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(arr[idx]<=tar)
        {
            temp.add(arr[idx]);
            solve(arr,idx,tar-arr[idx],ans,temp);
            temp.remove(temp.size()-1);
        }
        solve(arr,idx+1,tar,ans,temp);
    }
}