public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int longest = 0;
        
        for(int i = 0; i < nums.length; i++){
            int down = nums[i] - 1;
            
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            
            int up = nums[i] + 1;
            
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            
            longest = Math.max(longest, up - down - 1);
        }
        
        return longest;
    }
}