public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
        
        int majorElement1 = 0;
        int majorElement2 = 0;
        int majorTime1 = 0;
        int majorTime2 = 0;
        
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == majorElement1){
                majorTime1++;
            }else if(nums[i] == majorElement2){
                majorTime2++;
            }else if(majorTime1 == 0){
                majorElement1 = nums[i];
                majorTime1 = 1;
            }else if(majorTime2 == 0){
                majorElement2 = nums[i];
                majorTime2 = 1;
            }else{
                majorTime1--;
                majorTime2--;
            }   
        }
        
        majorTime1 = 0;
        majorTime2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == majorElement1){
                majorTime1++;
            }else if(nums[i] == majorElement2){
                majorTime2++;
            }else{
                continue;
            }
        }
        
        if(majorTime1 > nums.length / 3){
            res.add(majorElement1);
        }
        
        if(majorElement1 != majorElement2 && majorTime2 > nums.length / 3){
            res.add(majorElement2);
        }
        
        return res;
    }
}