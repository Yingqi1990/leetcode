/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = head;
        int step = 0;
        
        while(end != null && step < n ){
            end = end.next;
            step++;
        }
        
        if(step < n){
            return head;
        }
        
        while(end != null){
            end = end.next;
            prev =  prev.next;
        }
        
        prev.next = prev.next.next;
        
        return dummy.next;
    }
}