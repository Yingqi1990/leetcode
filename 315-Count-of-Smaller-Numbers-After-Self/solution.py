public class Solution {
    public List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
        
        BinarySearchTree bst = new BinarySearchTree();
        for(int i = nums.length - 1; i >=0; i--){
            res.add(0, bst.insertNode(nums[i]));
        }
        return res;
    }
}

class BinarySearchTree {
	 TreeNode root = null;
	    
	    public int insertNode(int val){
	        TreeNode node = new TreeNode(val);
	        
	        if(this.root == null){
	        	this.root = node;
	        	return 0;
	        }
	        
	        TreeNode curNode = this.root;
	        
	        while(curNode != null){
	        	if(curNode.val > node.val){
	        		curNode.leftCnt+= 1;
	                if(curNode.left == null){
	                	curNode.left = node;
	                	break;
	                }
	                curNode = curNode.left;
	        	}else if(curNode.val < node.val){
	        		node.leftCnt+= curNode.cnt + curNode.leftCnt;
	        		if(curNode.right == null){
	        			curNode.right = node;
	        			break;
	        		}
	        		curNode = curNode.right;
	        	}else{
	        		node.leftCnt+= curNode.leftCnt;
	        		curNode.cnt+=1;
	        		break;
	        	}
	        }
	        
	        return node.leftCnt;
	    }
}

class TreeNode {
	int val;
    int cnt = 1;
    int leftCnt = 0;
    TreeNode left = null;
    TreeNode right = null;
    
    public TreeNode(int val){
        this.val = val;
    }
}

