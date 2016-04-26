public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums == null && nums.length < 4){
            return res;
        }
        
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i > 2; i--){
            if(i < nums.length - 1 && nums[i] == nums[i + 1]){
                continue;
            }
            
            ArrayList<List<Integer>> sum3 = new ArrayList<List<Integer>>();
            
            for(int j = i - 1; j > 1; j--){
                if(j < i - 1 && nums[j + 1] == nums[j]){
                    continue;
                }
        
                ArrayList<List<Integer>> sum2 = twoSum(nums, j - 1, target - nums[i] - nums[j]);
                
                for(int k = 0; k < sum2.size(); k++){
                    sum2.get(k).add(nums[j]);
                }
                
                sum3.addAll(sum2);
            }
            
            for(int t = 0; t < sum3.size(); t++){
                 sum3.get(t).add(nums[i]);
            }
            
            res.addAll(sum3);
        }
        
        return res;
    }
    
    public ArrayList<List<Integer>> twoSum(int[] nums, int end, int target){
             int left = 0;
             int right = end;
             
             ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
             
             while(left < right){
                 if(nums[left] + nums[right] == target){
                     List<Integer> sb = new ArrayList<Integer>();
                     sb.add(nums[left]);
                     sb.add(nums[right]);
                     res.add(sb);
                     left ++;
                     right --;
                     
                     while(left < right && nums[left - 1] == nums[left] ){
                         left++;
                     }
                     
                     while(left < right && nums[right + 1] == nums[right]){
                         right--;
                     }
                     
                 }else if(nums[left] + nums[right] > target){
                     
                     right--;
                 
                 }else{
                     
                     left++;
                 
                 }
             }
             
             return res;
    }
    
}