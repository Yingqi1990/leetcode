public class Solution {
    public int findMin(int[] nums) {
     if(nums==null || nums.length==0) return -1;
     int left = 0;
     int right = nums.length-1;
     int min = nums[0];
     while(left+1<right){
         int mid = left + (right-left)/2;
         if(nums[left]<nums[mid]){
             min = Math.min(nums[left],min);
             left = mid+1;
         }else if(nums[left]>nums[mid]){
             min = Math.min(nums[mid], min);
             right = mid-1;
         }else{
             left++;
         }
     }
     min = Math.min(nums[left],min);
     min = Math.min(nums[right], min);
     return min;
    }
}