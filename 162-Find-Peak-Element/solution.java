public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        int mid = 0;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            
            if((mid == 0 || nums[mid] > nums[mid - 1] ) && ( mid == nums.length - 1 || nums[mid] > nums[mid + 1] )){
                return mid;
            }else if(mid < nums.length - 1 && nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return mid;
    }
}