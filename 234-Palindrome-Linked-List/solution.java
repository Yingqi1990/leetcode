/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        
        ListNode mid = findMiddle(head);
        mid.next = reverse(mid.next);
        
        ListNode p1 = head;
        ListNode p2 = mid.next;
        
        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
               return false;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
    
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode dummy = null;
        
        while(head != null){
            ListNode temp = head.next;
            head.next = dummy;
            dummy = head;
            head = temp;
        }
        
        return dummy;
    }
    
}