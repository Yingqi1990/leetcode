public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n < 0){
            return res;
        }
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> subset = new ArrayList<Integer>();
        helper(res, subset, nums, 0, k, n);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> subset, int[] nums, int start, int k, int target){
        if(subset.size() == k){
            if(target == 0){
                List<Integer> item = new ArrayList<Integer>(subset);
                res.add(item);
                return;
            }else{
                return;
            }
        }else{
            if(target > 0){
                for(int i = start; i < nums.length; i++ ){
                    subset.add(nums[i]);
                    helper(res, subset, nums, i+1, k, target-nums[i]);
                    subset.remove(subset.size()-1);
                }
            }else{
                return;
            }
        }
        return;
    }
}