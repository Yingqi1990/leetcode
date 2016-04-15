public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
           return true;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 2; i <= s.length() + 1; i++){
            for(int j = 1; j <= i - 1; j++){
                String temp = s.substring(j-1, i-1);
                if(wordDict.contains(temp) && dp[j - 1] == true){
                       dp[i - 1] = true;     
                }
            }
        }
        return dp[s.length()];
    }
}