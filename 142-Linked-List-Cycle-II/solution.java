/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
         if(head == null){
             return null;
         }
         
         ListNode slow = head;
         ListNode fast = head;
         
         while(true){
             if(fast.next == null || fast.next.next == null){
                 return null;
             }
             
             fast = fast.next.next;
             slow = slow.next;
             
             if(fast == slow){
                 break;
             }
         }
         
         slow = head;
         
         while(true){
             if(slow == fast){
                 return slow;
             }else{
                 slow = slow.next;
                 fast = fast.next;
             }
         }
         
    }
}