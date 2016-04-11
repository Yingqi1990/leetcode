public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<Integer>();
        boolean[] used = new boolean[candidates.length];
        helper(res, subset, candidates, target, 0, used);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> subset, int[] candidates, int target, int start, boolean[] used){
        if(target < 0){
            return;
        }else if(target == 0){
            List<Integer> item = new ArrayList<Integer>(subset);
            res.add(item);
            return;
        }else{
            for(int i = start; i < candidates.length; i++){
                if(i>0 && used[i-1]==false && candidates[i-1]==candidates[i]){
                    continue;
                }else{
                    used[i] = true;
                    subset.add(candidates[i]);
                    helper(res, subset, candidates, target-candidates[i], i+1, used);
                    subset.remove(subset.size()-1);
                    used[i] = false;
                }
            }
        }
        
    }
}