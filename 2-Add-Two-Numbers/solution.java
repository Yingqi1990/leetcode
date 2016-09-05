/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = head;
        int digit = 0;
        int carry = 0;
        while(l1!= null && l2!=null){
            digit = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode newNode = new ListNode(digit);
            
            if(head == null){
                head = newNode;
            }else{
                prev.next = newNode;
            }
            
            prev = newNode;
            
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        while(l1!=null){
            digit = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newNode = new ListNode(digit);
            
            if(head == null){
                head = newNode;
            }else{
                prev.next = newNode;
            }
            
            prev = newNode;
            
            l1 = l1.next;
        }
        
        while(l2!=null){
             digit = (l2.val + carry) % 10;
             carry = (l2.val + carry) / 10;
             ListNode newNode = new ListNode(digit);
             
             if(head == null){
                 head = newNode;
             }else{
                 prev.next = newNode;
             }
             
             prev = newNode;
             
             l2 = l2.next; 
        }
        
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
        }
        
        return head;
    }
}