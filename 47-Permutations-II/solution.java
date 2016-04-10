public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0){
            return res;     
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> subset = new ArrayList<Integer>();
        helper(res, nums, subset, used);
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] nums, List<Integer> subset, boolean[] used){
        if(subset.size()==nums.length){
            List<Integer> item = new ArrayList<Integer>(subset);
            res.add(item);
            return;
        }
        for(int i=0; i<nums.length; i++){
            
            if( i>0 && used[i-1]==false && nums[i-1]==nums[i] ){ 
                continue;
            }
            
            if(!used[i]){
                used[i] = true;
                subset.add(nums[i]);
                helper(res, nums, subset, used);
                subset.remove(subset.size()-1);
                used[i] = false;
            }
        }
        return;
    }  
}