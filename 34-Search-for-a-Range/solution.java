public class Solution {
    public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = -1;
    res[1] = -1;
    if(nums==null && nums.length==0) return res;
    int left = 0;
    int right = nums.length-1;
    int mid = left + (right-left)/2;
    while(left<=right){
        mid = left+(right-left)/2;
        if(nums[mid]==target) break;
        if(nums[mid]>target){ 
            right = mid-1;
        }else{
            left= mid+1;
        }
    }
    if(nums[mid]!=target) return res;
    int lr=mid;
    int ll=0;
    while(ll<=lr){
        int lm = ll+(lr-ll)/2;
        if(nums[lm]==target){
              lr = lm-1;    
        }else{
             ll = lm+1;
        }
    }
    res[0] = ll;
    int rl = mid;
    int rr = nums.length-1;
    while(rl<=rr){
        int rm = rl+(rr-rl)/2;
        if(nums[rm]==target){
            rl = rm+1;
        }else{
            rr=rm-1;
        }
    }
    res[1] = rr;
    return res;
    }
}