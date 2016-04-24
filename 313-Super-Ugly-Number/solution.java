public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes == null || primes.length == 0 || n < 1){
            return -1;
        }
        
        int[] uglyNum = new int[n];
        int[] timeIndex = new int[primes.length];
        uglyNum[0] = 1;
        
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            
            for(int j = 0; j < primes.length; j++){
                if(min > primes[j]*uglyNum[timeIndex[j]]){
                   min = primes[j]*uglyNum[timeIndex[j]];
                }
            }
            
            uglyNum[i] = min;
            
            for(int j =0; j < primes.length; j++){
                  if(primes[j]*uglyNum[timeIndex[j]] == min){
                      timeIndex[j]++;
                  }
            }
        }
        
        return uglyNum[n-1];
    }
    
}