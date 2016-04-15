public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        boolean[][] palMatrix = getPal(s);
        int[] dp = new int[s.length()+1];
        dp[0] = 0;
        for(int i = 1; i <= s.length(); i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++ ){
                if(palMatrix[j-1][i-1] == true){
                    dp[i] = Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[s.length()] - 1;
    }
    
    public boolean[][] getPal (String s){
        boolean[][] palMatrix = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            palMatrix[i][i] = true; 
        }
        
        for(int i=1; i < s.length(); i++){
           if(s.charAt(i-1) == s.charAt(i)){
               palMatrix[i-1][i] = true;
           }
        }
        
        for(int len = 2; len < s.length(); len++){
            for(int i = 0; i < s.length() - len; i++){
                if(s.charAt(i) == s.charAt(i+len) && palMatrix[i+1][i+len-1] == true){
                    palMatrix[i][i+len] = true;
                }
            }
        }
        return palMatrix;
    }
}