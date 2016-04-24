public class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[3];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 5;
        int[] uglyNum = new int[n];
        int[] timeIndex = new int[nums.length];
        uglyNum[0] = 1;
        
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            
            for(int j = 0; j < nums.length; j++){
                min = Math.min(min, nums[j]*uglyNum[timeIndex[j]] );
            }
            
            uglyNum[i] = min;
            
            for(int j = 0; j < nums.length; j++){
                if(nums[j]*uglyNum[timeIndex[j]] == min){
                     timeIndex[j]++;
                }
            }
            
        }
        
        return uglyNum[n-1]; 
    }
}