public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int left = 1; 
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left +(right - left)/2;
            int count = 0;
            
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            
            if(count <= mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return left;
    }
}