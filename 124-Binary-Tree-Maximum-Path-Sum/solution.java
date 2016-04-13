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
    public class NodeInfo{
        int maxPath, singlePath;
        public NodeInfo(int maxPath, int singlePath){
            this.maxPath = maxPath;
            this.singlePath = singlePath;
        }
    }
    
    public NodeInfo helper(TreeNode root){
        if(root == null){
            return new NodeInfo(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath) )+ root.val;
        maxPath = Math.max(maxPath, Math.max(left.singlePath, 0)+Math.max(0, right.singlePath) + root.val);
        return new NodeInfo(maxPath, singlePath);
    }
    
    public int maxPathSum(TreeNode root) {
           NodeInfo res = helper(root);
           return res.maxPath;
    }
}