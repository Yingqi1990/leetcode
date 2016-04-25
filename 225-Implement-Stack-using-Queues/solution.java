class MyStack {
    // Push element x onto stack.
    Queue<Integer> inQueue = new LinkedList<Integer>();
    Queue<Integer> outQueue = new LinkedList<Integer>();
    
    public void push(int x) {
        inQueue.offer(x);
        
        while(!outQueue.isEmpty()){
            inQueue.offer(outQueue.poll());
        }
        
        Queue tmp = outQueue;
        outQueue = inQueue;
        inQueue = tmp;
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!outQueue.isEmpty()){
           outQueue.poll();
        }
    }

    // Get the top element.
    public int top() {
        if(!outQueue.isEmpty()){
            return outQueue.peek();
        }else{
            return 0;
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return outQueue.isEmpty();
    }
}