public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int range = 0;
        int step = 0;
        int maxRange = 0;
        
        for(int i = 0; i <= range && i < nums.length; i++){
            if(i > maxRange){
                step++;
                maxRange = range;
            }
            
            range = Math.max(nums[i]+i, range);
        }
        
        if(range < nums.length-1){
            return -1;
        }
        
        return step;
        
    }
}