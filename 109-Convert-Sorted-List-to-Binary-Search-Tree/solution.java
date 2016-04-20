/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        int len = getLength(head);
        ArrayList<ListNode> rootRecord = new ArrayList<ListNode>();
        rootRecord.add(head);
        
        return helper(rootRecord, 0, len - 1);
    }
    
    public TreeNode helper(ArrayList<ListNode> rootRecord, int left, int right){
        if(left > right){
            return null;
        }
        
        int mid = left + (right - left)/2;
        TreeNode leftTree = helper(rootRecord, left, mid - 1);
        TreeNode root = new TreeNode(rootRecord.get(0).val);
        root.left = leftTree;
        rootRecord.set(0, rootRecord.get(0).next);
        TreeNode rightTree = helper(rootRecord, mid + 1, right);
        root.right = rightTree;
        
        return root;
    }
    
    
    public int getLength(ListNode head){
         ListNode cur = head;
         int len = 0;
         while(cur != null){
             len++;
             cur = cur.next;
         }
         return len;
    }
    
}