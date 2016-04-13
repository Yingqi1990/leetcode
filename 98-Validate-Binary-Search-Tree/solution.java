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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> lastVal = new ArrayList<Integer>();
        lastVal.add(null);
        return helper(root, lastVal);
    }
    
    public boolean helper(TreeNode root, ArrayList<Integer> lastVal){
        if(root == null){
            return true;
        }
        
        boolean left = helper(root.left, lastVal);
        
        if(lastVal.get(0) != null && lastVal.get(0) >= root.val){
            return false;
        }
        
        lastVal.set(0, root.val);
        
        return left && helper(root.right, lastVal);
        
    }
}