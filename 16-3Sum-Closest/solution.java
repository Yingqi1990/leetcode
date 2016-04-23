public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        int closest = nums[0] + nums[1] + nums[2] - target;
        
        for(int i = 0; i <= len - 3; i++){
            int min = twoSumClosest(nums, i + 1, target-nums[i]);
            
            if(Math.abs(closest) >  Math.abs(min)){
                  closest = min;
            }
            
        }
    
        return closest + target;
    }
    
    public int twoSumClosest(int[] nums, int start, int target){
        int min = nums[start] + nums[start + 1] - target;
        int left = start;
        int right = nums.length - 1;
        
        while(left < right){
            if(nums[left] + nums[right] == target){
                
                return 0;
                
            }else if(nums[left] + nums[right] > target){
                
                if(Math.abs(min) > nums[left] + nums[right] - target){
                      min = nums[left] + nums[right] - target;
                }
                
                right--;
                
            }else{
                
                if(Math.abs(min) > target - nums[left] - nums[right]){
                      min = nums[left] + nums[right] - target;
                }
                
                left++;
            }
        }
        
        return min;
    }
}