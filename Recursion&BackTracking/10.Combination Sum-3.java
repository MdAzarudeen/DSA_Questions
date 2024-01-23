https://leetcode.com/problems/combination-sum-iii/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        int[]arr = {1,2,3,4,5,6,7,8,9};
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        combo(0,k,arr,target,new ArrayList<>(), set);
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    public void combo(int idx, int k, int[]arr, int target,
                      List<Integer> ds,HashSet<ArrayList<Integer>> set )
    {
        if(target==0 && ds.size()==k )
        {
            Collections.sort(ds);
            set.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx; i<arr.length; i++)
        {
            if(i>idx && arr[i]==arr[i-1])   continue;
            if(arr[i]>target)   break;
            ds.add(arr[i]);
            combo(i+1,k,arr,target-arr[i],ds,set);
            ds.remove(ds.size()-1);
        }
    }
}