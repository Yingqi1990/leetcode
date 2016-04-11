public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       if(candidates == null || candidates.length == 0){
             return res;
       }
       Arrays.sort(candidates);
       List<Integer> subset = new ArrayList<Integer>();
       helper(res, candidates, target, subset, 0);
       return res;
    }
    
    public void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> subset, int start){
        if(target < 0){
            return;
        }else if(target == 0){
            List<Integer> item = new ArrayList<Integer>(subset);
            res.add(item);
            return;
        }else{
            for(int i = start; i < candidates.length; i++){
                if(i > 0 && candidates[i-1] == candidates[i] ){
                    continue;
                }else{
                    subset.add(candidates[i]);
                    helper(res, candidates, target-candidates[i], subset, i);
                    subset.remove(subset.size()-1);
                }
            }
        }
    }
}