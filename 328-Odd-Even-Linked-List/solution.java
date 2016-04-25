/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
         if(head == null || head.next == null){
             return head;
         }
         
         ListNode cur1 = head;
         ListNode cur2 = head.next;
         ListNode head2 = cur2;
         
         while(true){
             if(cur1.next != null && cur1.next.next !=null){
                 cur1.next = cur1.next.next;
                 cur1 = cur1.next;
             }else{
                 break;
             }
         
             if(cur2.next !=null && cur2.next.next != null){
                 cur2.next = cur2.next.next;
                 cur2 = cur2.next;
             }else{
                 break;
             }
         
         }
         
         cur2.next = null;
         cur1.next = head2;
         
         return head;
         
    }
}