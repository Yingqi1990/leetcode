public class Solution {
    public int maxProfit(int[] prices) {
         if(prices == null || prices.length == 0){
             return 0;
         }
         
         if(prices.length <= 4){
             int maxProfit = 0;
             for(int i = 0; i < prices.length - 1; i++){
                 maxProfit+= Math.max(prices[i+1] - prices[i], 0);
             }
             
             return maxProfit;
         }
         
         int len = prices.length;
         int num = 2;
         
         int[][] mustSel = new int[len][num+1];
         int[][] globalBest = new int[len][num+1];
         
         for(int i = 0;  i < len; i++){
             mustSel[i][0] = 0;
             globalBest[i][0] = 0;
         }
         
         for(int i = 1; i <= num; i++){
             mustSel[0][i] = 0;
             globalBest[0][i] = 0;
             
             for(int j = 1; j < len; j++){
               mustSel[j][i] = Math.max(mustSel[j-1][i] + prices[j] - prices[j-1], globalBest[j-1][i-1] +  prices[j] - prices[j-1] );
               globalBest[j][i] = Math.max(mustSel[j][i], globalBest[j-1][i]);
             }
             
         }
         
         return globalBest[len-1][num];
         
         
    }
}