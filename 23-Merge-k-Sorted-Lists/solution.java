/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }
    
    public ListNode helper(ListNode[] lists, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            return merge(helper(lists, left, mid), helper(lists, mid+1, right));
        }else{
            return lists[left];
        }
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
           ListNode dummy = new ListNode(-1);
           dummy.next =  l1;
           ListNode cur = dummy;
           
           while(l1 != null && l2 != null){
               if(l1.val < l2.val){
                   l1 = l1.next;
               }else{
                   cur.next = l2;
                   ListNode next = l2.next;
                   l2.next = l1;
                   l2 = next;
               }
               cur = cur.next;
           }
           
           if(l2 != null){
               cur.next = l2;
           }
        
        return dummy.next;
    }
}