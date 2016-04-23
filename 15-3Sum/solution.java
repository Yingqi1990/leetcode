public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> res = new ArrayList<List<Integer>>();
         
         if(nums == null || nums.length < 3){
             return res;
         }
         
         Arrays.sort(nums);
         
         for(int i = nums.length - 1; i >= 2; i--){
             if( i < nums.length - 1 && nums[i] == nums[i + 1] ){
                 continue;
             }
             
             ArrayList<List<Integer>> sb = twoSum(nums, i - 1, -nums[i]);
             
             for(int j = 0; j < sb.size(); j++){
                   sb.get(j).add(nums[i]);
             }
             
             res.addAll(sb);
             
         }
         
         return res;
    }
    
    public ArrayList<List<Integer>> twoSum(int[] nums, int end, int target){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int left = 0;
        int right = end;
        
        while(left < right){
            if(nums[left] + nums[right] == target){
                List<Integer> sb = new ArrayList<Integer>();
                sb.add(nums[left]);
                sb.add(nums[right]);
                res.add(sb);
                left++;
                right--;
                
                while(left < right && nums[left-1] == nums[left]){
                    left++;
                }
                
                
                while(left < right && nums[right] == nums[right + 1]){
                    right--;
                }
                
                
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        
        return res;
    }
}