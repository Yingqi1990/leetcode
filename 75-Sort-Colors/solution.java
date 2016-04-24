public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        int cur = 0;
        
        while(cur <= right){
            if(nums[cur] == 0){
                int temp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = temp;
                left++;
                cur++;
            }else if(nums[cur] == 1){
                cur++;
            }else{
                int temp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = temp;
                right--;
            }
        }
    }
}