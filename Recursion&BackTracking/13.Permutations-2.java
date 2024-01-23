https://leetcode.com/problems/permutations-ii/description/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[]freq = new boolean[nums.length];
        solve(nums,ans,list,freq);
        return ans;
    }
    public void solve(int[]nums, List<List<Integer>> ans ,
                      List<Integer> list , boolean[]freq)
    {
        if(list.size()==nums.length && !ans.contains(list))
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(!freq[i])
            {
                freq[i]=true;
                list.add(nums[i]);
                solve(nums,ans,list,freq);
                list.remove(list.size()-1);
                freq[i]=false;
            }
        }
    }
}