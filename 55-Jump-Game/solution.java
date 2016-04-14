public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        
        int range = 0;
        
        for(int i = 0; i <=range && i < nums.length-1; i++){
            range = Math.max(range, nums[i]+i);
        }
        
        if(range < nums.length-1){
            return false;
        }
        
        return true;
    }
}