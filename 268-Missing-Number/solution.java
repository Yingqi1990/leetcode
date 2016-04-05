public class Solution {
    public int missingNumber(int[] nums) {
        int xor=nums.length;
        for(int i=0; i<nums.length; i++){
            xor=xor^i^nums[i];
        }
        return xor;
    }
}