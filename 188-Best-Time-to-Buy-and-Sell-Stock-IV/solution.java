public class Solution {
    public int maxProfit(int k, int[] prices) {
       if(k == 0){
           return 0;
       }
       
       int len = prices.length;
       int profit = 0;
       
       if( k >= (len+1)/2){
           for(int i =1; i < len; i++){
               if(prices[i] - prices[i-1] > 0){
                   profit+= prices[i] - prices[i-1]; 
               }
           }
           
           return profit;
       }
       
       int[][] mustSel = new int[len][k+1];
       int[][] globalBest = new int[len][k+1];
       
       for(int i = 0; i <= k; i++){
           mustSel[0][i] = 0;
           globalBest[0][i] = 0;
       }
       
       for(int i = 1; i < len; i++){
           mustSel[i][0] = 0;
           globalBest[i][0] = 0;
           
           int loseGain = prices[i] - prices[i-1];
           for(int j = 1; j <=k ; j++){
               mustSel[i][j] = Math.max(mustSel[i-1][j] + loseGain, globalBest[i-1][j-1] + loseGain);
               globalBest[i][j] = Math.max(mustSel[i][j], globalBest[i-1][j]);
           }
       }
       
       return globalBest[len-1][k];
       
    }
}