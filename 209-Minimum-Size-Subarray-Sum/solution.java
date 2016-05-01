public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int[] sums = new int[len + 1];
        int min = len + 1;
        
        for(int i = 1; i < len + 1; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        for(int i = 0; i < len + 1; i++){
            int right = searchRight(i+1, len, sums[i] + s ,sums);
            
            if(right == len + 1){
                break;
            }
            
            if(min > right - i){
                min = right - i;
            }
        }
        
        return min == len + 1 ? 0 : min;
    }
    
    public int searchRight(int left, int right, int target, int[] sums){
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(sums[mid] >= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            
            return left;
    }
    
}