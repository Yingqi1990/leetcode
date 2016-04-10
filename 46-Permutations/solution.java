public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return res;
        }
        List<Integer> subset = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        helper(res, subset, used, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> subset, boolean[] used, int[] nums){
        if(subset.size()==nums.length){
            List<Integer> item = new ArrayList<Integer>(subset);
            res.add(item);
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                subset.add(nums[i]);
                helper(res, subset, used, nums);
                subset.remove(subset.size()-1);
                used[i] = false;
            }
        }
        return;
    }
}