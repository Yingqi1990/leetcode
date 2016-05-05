public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int i;
        for(i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                 break;
            }
        }
            
       if(i >= 0){
           int j = i + 1;
                
           while(j < nums.length && nums[j] > nums[i] ){
                j++;
           }
                
           j--;
                
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
        }
            
        reverse(i + 1, nums);

    }
    
    public void reverse(int index, int[] nums){
        int left = index;
        int right = nums.length - 1;
        
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        
    }
}