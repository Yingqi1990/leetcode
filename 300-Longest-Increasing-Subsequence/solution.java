public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }
        
        int longest = 1; 
        
        for(int i = 1; i < dp.length; i++){
            int maxValue = Integer.MIN_VALUE;
            for(int j = i - 1; j >=0; j--){
                if(nums[i] > nums[j]){
                   dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        
        return longest;
    }
}