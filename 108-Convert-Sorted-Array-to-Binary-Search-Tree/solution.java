/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        
        int len = nums.length;
        
        return helper(nums, 0, len - 1);
    }
    
    public TreeNode helper(int[] nums, int left, int right){
            if(left > right){
                return null;
            }
            
            int mid = left + (right - left)/2;
            TreeNode leftTree = helper(nums, left, mid - 1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = leftTree;
            TreeNode rightTree = helper(nums, mid+1, right);
            root.right = rightTree;
            
            return root;
    }
}