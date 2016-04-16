public class Solution {
     public boolean isInterleave(String s1, String s2, String s3) {
        if(s3 == null){
            return false;
        }else if( s1 == null && s2 == null){
            return false;
        }else if( s1 == null && s2!= null){
            if(s2.length() !=s3.length()){
                return false;
            }else{
                for(int i=0; i < s3.length(); i++){
                    if(s2.charAt(i) != s3.charAt(i)){
                         return false;
                    }
                }
                return true;
            }
        }else if( s1 != null && s2 == null ){
           if(s1.length() !=s3.length()){
                return false;
            }else{
                for(int i=0; i < s3.length(); i++){
                    if(s1.charAt(i) != s3.charAt(i)){
                         return false;
                    }
                }
                return true;
            } 
        }else{
             if(s3.length() != s1.length() + s2.length()){
                 return false;
             }else{
                 int len1 = s1.length();
                 int len2 = s2.length();
                 boolean[][] dp = new boolean[len1 + 1][len2 + 1];
                 dp[0][0] = true;
                 
                 for(int i = 1; i <= len1; i++){
                     if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]){
                          dp[i][0] = true;   
                     }
                 }
                 
                 for(int i = 1; i <= len2; i++){
                     if(s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1]){
                         dp[0][i] =true;
                     }
                 }
                 
                 for(int i = 1; i <= len1; i++){
                     for(int j = 1; j <= len2; j++){
                         if(s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]){
                             dp[i][j] = true;
                         }else if((s2.charAt(j-1) == s3.charAt(i+j-1)) && dp[i][j-1]){
                             dp[i][j] = true;
                         }else{
                             dp[i][j] = false;
                         }
                     }
                 }
                 
                 return dp[len1][len2];
             }
        } 
     }
}