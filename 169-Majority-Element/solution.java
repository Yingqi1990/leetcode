public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        int maxNum = 0;
        int maxMajor = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) > maxNum){
                maxMajor = nums[i];
                maxNum = map.get(nums[i]);
            }
        }
        
        return maxMajor;
    }
}