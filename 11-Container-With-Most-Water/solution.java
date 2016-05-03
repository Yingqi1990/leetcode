public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1){
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        
        
        while(left < right){
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            
            if(height[left] < height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        
        return max;
    }
}