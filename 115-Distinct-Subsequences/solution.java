public class Solution {
    public int numDistinct(String s, String t) {
      if(s == null || t == null){
          return 0;
      }
      
      int len1 = s.length();
      int len2 = t.length();
      int[][] dp = new int[len1+1][len2+1];
      
      for(int i = 0; i <= len1; i++){
          dp[i][0] = 1;
      }
      
      for(int j = 1; j<=len2; j++){
          dp[0][j] = 0;
      }
      
      for(int j = 1; j <= len2; j++){
          for(int i = 1; i<= len1; i++){
              if( i < j){
                  dp[i][j] = 0;
              }else{
                  if(s.charAt(i-1) == t.charAt(j-1)){
                      dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                  }else{
                      dp[i][j] = dp[i-1][j];
                  }
              }
          }
      }
      
      return dp[len1][len2];
    }
}