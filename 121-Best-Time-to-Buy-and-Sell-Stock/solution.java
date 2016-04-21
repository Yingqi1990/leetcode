public class Solution {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length <= 1){
           return 0;
       }
       
       int minBuy = prices[0];
       int maxProfit = 0;
       
       for(int i = 1; i < prices.length; i++){
           int tempProfit = prices[i] - minBuy;
           maxProfit = Math.max(maxProfit, tempProfit);
           minBuy = Math.min(minBuy, prices[i]);
       }
       
       return maxProfit;
    }
}