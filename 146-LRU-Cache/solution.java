public class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    
    public LRUCache(int capacity) {
         this.capacity = capacity;
         head.next = tail;
         tail.prev = head;
    }
    
    public int get(int key) {
        if(!hs.containsKey(key)){
           return -1;   
        }
        
        Node cur = hs.get(key);
        cur.prev.next = cur.next;
        cur.next.prev= cur.prev;
        cur.next = tail;
        tail.prev.next = cur;
        cur.prev = tail.prev;
        tail.prev = cur;
        
        return hs.get(key).value;
    }
    
    public void set(int key, int value) {
        if(get(key) != -1){
            hs.get(key).value = value;
            return;
        }
        
        if(hs.size() == capacity){
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node cur = new Node(key, value);
        hs.put(key, cur);
        
        tail.prev.next = cur;
        cur.next = tail;
        cur.prev = tail.prev;
        tail.prev = cur;
    }
}