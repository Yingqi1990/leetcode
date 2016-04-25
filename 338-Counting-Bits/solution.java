public class Solution {
    public int[] countBits(int num) {
        if(num < 0){
            return null;
        }
        
        if(num == 0){
            int[] res ={0};
            return res;
        }
        
        if(num == 1){
            int[] res = {0,1};
            return res;
        }
        
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= num; i++){
            dp[i] = dp[i/2] + i % 2;
        }
        
        return dp;
    }
}