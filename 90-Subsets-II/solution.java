public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if(nums == null){
          return res;
      }
      Arrays.sort(nums);
      ArrayList<Integer> mark = new ArrayList<Integer>();
      mark.add(0);
      helper(res, nums, nums.length-1, mark);
      return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, int index, ArrayList<Integer> mark){
        if(index==-1){
            List<Integer> subset = new ArrayList<Integer>();
            res.add(subset);
            return;
        }
        helper(res, nums, index-1, mark);
        int size = res.size();
        int start = 0;
        if(index > 0 && nums[index-1] == nums[index]){
            start = mark.get(0);
        }
        for(int i = start; i < size; i++){
            List<Integer> subset = new ArrayList<Integer>(res.get(i));
            subset.add(nums[index]);
            res.add(subset);
        }
        mark.set(0, size);
        return;
    }
}