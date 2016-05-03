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
                int temp = nums[cur];
                nums[cur] = nums[left];
                nums[left] = temp;
                cur++;
                left++;
            }else if(nums[cur] == 1){
                cur++;
            }else{
                int temp = nums[cur];
                nums[cur] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        
    }
}