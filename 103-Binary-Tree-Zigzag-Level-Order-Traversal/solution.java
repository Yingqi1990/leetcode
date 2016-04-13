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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        currentLevel.push(root);
        boolean mark = true;
        
        while(!currentLevel.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = currentLevel.size();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = currentLevel.pop();
                level.add(temp.val);
                
                if(mark){
                    
                   if(temp.left != null){
                       nextLevel.push(temp.left);
                   }
                   
                   if(temp.right != null){
                       nextLevel.push(temp.right);
                   }
                   
                }else{
                    
                    if(temp.right != null){
                        nextLevel.push(temp.right);
                    }
                    
                    if(temp.left != null){
                        nextLevel.push(temp.left);
                    }
                }
            }
            res.add(level);
            tmp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = tmp;
            mark = !mark;
        }
        
        return res;
    }
}