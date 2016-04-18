public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return -1.0;
        }else if(nums2 == null){
            if(nums1.length%2 == 0){
                return (nums1[nums1.length/2] + nums1[(nums1.length - 1)/2])/2.0;
            }else{
                return nums1[nums1.length/2];
            }
        }else if(nums1 == null){
            if(nums2.length%2 == 0){
                return (nums2[nums2.length/2] + nums2[(nums2.length - 1)/2])/2.0;
            }else{
                return nums2[nums2.length/2];
            }
        }else{
            if((nums1.length + nums2.length)%2 == 1){
                return helper(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (nums1.length + nums2.length)/2+1)/1.0;
            }else{
                return ( helper(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (nums1.length + nums2.length)/2) + helper(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (nums1.length + nums2.length)/2 + 1) )/2.0;
            }
        }
    }
    
    public int helper(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k){
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        if(len1 < len2){
            return helper(nums2, l2, r2, nums1, l1, r1, k);
        }
        
        if(len2 == 0){
            return nums1[l1 + k -1]; 
        }
        
        if(k == 1){
            return Math.min(nums1[l1], nums2[l2]);
        }
        
        int pos2 = Math.min(len2, k/2);
        int pos1 = k - pos2;
        
        if(nums1[l1 + pos1 -1] == nums2[l2 + pos2 -1]){
            return nums1[l1 + pos1 -1];
        }
        
        if(nums1[l1 + pos1 -1] > nums2[l2 + pos2 -1]){
            return helper(nums1, l1, l1 + pos1 -1, nums2, l2 + pos2, r2, k - pos2);    
        }else{
            return helper(nums1, l1 + pos1, r1, nums2, l2, l2 + pos2 - 1, k - pos1);
        }
        
    }
    
}