public class Solution {
     public int minCut(String s){
	   if(s==null || s.length() == 0){
		   return -1;
	   }
	   boolean[][] isPal = getPal(s);
	   int[] dp = new int[s.length()+1];
	   dp[0] = 0;
	   for(int i =1; i <= s.length(); i++){
		   dp[i] = Integer.MAX_VALUE;
		   for(int j = 0; j <i ; j++ ){
			   if(isPal[j][i-1]){
			   dp[i] = Math.min(dp[i], dp[j]+1); 
			   }
		   }
	   }
	   return dp[s.length()]-1; 
   }
   
   public boolean[][] getPal(String s){
	   
	   boolean[][] isPal = new boolean[s.length()][s.length()];
	   
	   for(int i = 0; i < s.length(); i++){
		   isPal[i][i] = true;
	   }
	   
	   for(int i=0; i<s.length() - 1; i++){
		   if(s.charAt(i) == s.charAt(i+1)){
		      isPal[i][i+1] = true;
		   }
	   }
	   
	   for(int len = 2; len < s.length(); len++){
		 
		   for(int i=0; i+len < s.length(); i++){
		      isPal[i][i+len] = isPal[i+1][i+len-1] && (s.charAt(i) == s.charAt(i+len));	   
		   }
	   
	   }
	   
	   return isPal;
   }
}