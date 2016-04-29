public class Solution {
    public int findMin(int[] nums) {
       if(nums == null || nums.length == 0){
           return 0;
       }
       
       int left = 0;
       int right = nums.length - 1;
       int min = Integer.MAX_VALUE;
       
       while(left <= right){
           int mid = left + (right - left) / 2;
           
           if(nums[left] < nums[mid]){
                min = Math.min(min, nums[left]);
                left = mid + 1;
           }else if(nums[left] > nums[mid]){
                min = Math.min(min, nums[mid]);
                right = mid - 1;
           }else{
               min = Math.min(min, nums[left]);
               left++;
           } 
       }
       
       return min;
       
    }
}