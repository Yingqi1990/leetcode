/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = slow.next;
        slow.next = null;
        ListNode headRight = reverseList(right);
        head = mergeList(head, headRight);
    }
    
    public ListNode reverseList(ListNode head){
        if(head.next == null){
            return head;
        }
        
        ListNode dummy = null;
        ListNode temp;
        
        while(head != null){
            temp = head.next;
            head.next = dummy;
            dummy = head;
            head = temp;
        }
        
        return dummy;
    }
    
    public ListNode mergeList(ListNode leftList, ListNode rightList){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(leftList != null && rightList != null){
             tail.next = leftList;
             leftList = leftList.next;
             tail = tail.next;
             tail.next = rightList;
             rightList = rightList.next;
             tail = tail.next;
        }
        
        if(leftList != null){
            tail.next = leftList;
            tail = tail.next;
        }
        
        tail.next = null;
        
        return dummy.next;
    }
    
    
}