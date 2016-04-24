public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int len = nums.length - 1;
        int flag = nums.length - 1;
        
        for(int cur = len; cur >= 0; cur--){
            if(nums[cur] == 0){
               for(int j = cur; j < flag; j++){
                   nums[j] = nums[j + 1];
               }
               nums[flag] = 0;
               flag--;
            }
        }
    }
}