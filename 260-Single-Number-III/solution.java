public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length <= 0){
            return null;
        }
        
        int xor = 0;
        int[] res = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];
        }
        
        xor = xor - (xor & (xor - 1));
        
        int group0 = 0;
        int group1 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if((xor & nums[i]) == 0){
                group0 ^= nums[i]; 
            }else{
                group1 ^= nums[i] ;           
            }
        }
        
        res[0] = group0;
        res[1] = group1;
        
        return res;
    }
}