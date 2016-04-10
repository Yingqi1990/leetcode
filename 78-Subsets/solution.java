public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
	    Arrays.sort(nums);
	    if(nums == null){
	    	return res;
	    }
	    helper(res, nums, nums.length-1);
	    return res;
   }
   public void helper(List<List<Integer>> res, int[] nums, int index){
	   if(index==-1){
		   List<Integer> subset = new ArrayList<Integer>();
		   res.add(subset);
		   return;
	   }
	   helper(res, nums, index-1);
	   int size = res.size();
	   for(int i = 0; i < size; i++){
		   List<Integer> subset = new ArrayList<Integer>(res.get(i));
		   subset.add(nums[index]);
		   res.add(subset);
	   }
	   return;
    }
}