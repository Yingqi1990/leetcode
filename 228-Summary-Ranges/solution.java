public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
        
        int start = 0;
        int cur = 0;
        
        while(cur < nums.length){
            if(start == cur){
                cur++;
            }else{
                if(nums[cur] == nums[cur - 1] + 1){
                    cur++;
                }else{
                    if(nums[start] == nums[cur - 1]){
                        res.add(nums[cur - 1] + "");
                    }else{
                        res.add(nums[start] + "->" + nums[cur - 1]);
                    }
                    start = cur;
                }
            }
        }
        
        if(nums[start] == nums[cur - 1]){
                res.add(nums[cur - 1] + "");
        }else{
                res.add(nums[start] + "->" + nums[cur - 1]);
        }
        
        return res;
        
    }
}