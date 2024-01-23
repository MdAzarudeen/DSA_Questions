https://leetcode.com/problems/subsets/

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        if(nums==null || nums.length==0)    return ans;
        solve(nums,new ArrayList<>(), 0);
        return ans;
    }
    public void solve(int[]nums, ArrayList<Integer> temp, int st)
    {
        if(st>=nums.length)
        {
            ans.add(new ArrayList<>(temp));
            return ;
        }

        // pick
        temp.add(nums[st]);
        solve(nums,temp,st+1);
        // not pick
        temp.remove(temp.size()-1);
        solve(nums,temp,st+1);
    }
}