public class Solution {
    public boolean canJump(int[] nums) {
       /* if(nums == null || nums.length == 0){
            return true;
        }
        
        int range = 0;
        
        for(int i = 0; i <=range && i < nums.length-1; i++){
            range = Math.max(range, nums[i]+i);
        }
        
        if(range < nums.length-1){
            return false;
        }
        
        return true; */
        if(nums == null || nums.length == 0){
            return true;
        }
        
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = i-1; j>=0; j--){
                if(dp[j] && nums[j]+j >= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
        }
}