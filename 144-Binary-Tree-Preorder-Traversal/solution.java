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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}