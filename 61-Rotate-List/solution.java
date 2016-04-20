/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        int len = getLength(head);
        k = k % len;
        if( k == 0){
            return head;
        }
    
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i = 0 ; i < k - 1; i++){
            fast = fast.next;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        
        dummy.next = slow;
        fast.next = head;
        pre.next = null;
        
        return dummy.next;
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