/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m >= n || head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        int i = 1;
        ListNode preNode = head;
        
        while( preNode.next != null && i < m  ){
            preNode = preNode.next;
            i++;
        }
        
        ListNode mNode = preNode.next;
        ListNode cur = mNode.next;
        
        while(cur != null && i < n){
            ListNode temp = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            mNode.next = temp;
            cur = temp;
            i++;
        }
        
        return dummy.next;
        }
}