https://leetcode.com/problems/permutations-ii

//Given a collection of numbers, nums, that might contain duplicates,
//        return all possible unique permutations in any order.
//Example 1:
//        Input: nums = [1,1,2]
//        Output:
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(0,nums,ans);
        return ans;
    }
    public void perm(int idx, int[]nums, List<List<Integer>> ans)
    {
        if(idx>=nums.length)
        {
            List<Integer>abs= new ArrayList<>();

            for(int i=0; i<nums.length; i++)
                abs.add(nums[i]);
            if(!ans.contains(abs))
                ans.add(abs);
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            swap(i,idx,nums);
            perm(idx+1,nums,ans);
            swap(i,idx,nums);
        }
    }
    public void swap(int i, int idx, int[]nums)
    {
        int temp = nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
    }
}