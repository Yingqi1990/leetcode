public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        
        int[] output = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            output[i] = 1;
        }
        
        int left = 1;
        
        for(int i =0; i < nums.length - 1; i++){
            left = left * nums[i];
            output[i + 1]*= left;
        }
        
        int right = 1;
        
        for(int i = nums.length - 1; i > 0; i--){
            right = right * nums[i];
            output[i - 1]*= right;
        }
        
        return output;
    }
}