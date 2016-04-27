public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int[] bits = new int[32];
        int res = 0;
        
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
                bits[i]+= nums[j] >> i & 1;
            }
            
                res |= ((bits[i] % 3) << i);
        }
        
        return res;
    }
}