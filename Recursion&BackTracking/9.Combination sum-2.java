https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        solve(candidates,0,target,set,new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    public void solve(int[]arr, int idx, int tar,        HashSet<ArrayList<Integer>>set, ArrayList<Integer> temp)
    {
        if(tar==0)
        {
            Collections.sort(temp);
            set.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<arr.length; i++)
        {
            if(i>idx    && arr[i]==arr[i-1])    continue;
            if(arr[i]>tar)  break;
            temp.add(arr[i]);
            solve(arr,i+1,tar-arr[i],set,temp);
            temp.remove(temp.size()-1);
        }
    }
}