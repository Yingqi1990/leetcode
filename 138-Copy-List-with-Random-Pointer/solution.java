/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while(head != null){
            RandomListNode temp;
            
            if(map.containsKey(head)){
                temp = map.get(head);
                pre.next = temp;
            }else{
                temp = new RandomListNode(head.label);
                pre.next = temp;
                map.put(head, temp);
            }
            
            if(head.random != null){
               if(map.containsKey(head.random)){
                   temp.random = map.get(head.random);
               }else{
                   temp.random = new RandomListNode(head.random.label);
                   map.put(head.random, temp.random);
               }
            }
            
            pre = pre.next;
            head = head.next;
            
        }
        
        return dummy.next;
        
    }
}