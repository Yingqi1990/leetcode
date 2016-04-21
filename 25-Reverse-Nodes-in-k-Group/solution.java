/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         if(head == null || k <= 1){
             return head;
         }
         
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         head = dummy;
         
         while(head.next != null){
             head = helper(head, k);
         }
         
         return dummy.next;
    }
    
    public ListNode helper(ListNode head, int k){
        ListNode last = head;
        int i = 0;
        
        while(last.next != null && i < k){
            last = last.next;
            i++;    
        }
        
        if(i < k){
            return last;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode n1 = head.next;
        
        for(i = 0; i < k; i++){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        n1.next = cur;
        head.next = prev;
        
        return n1;

    }
    
}