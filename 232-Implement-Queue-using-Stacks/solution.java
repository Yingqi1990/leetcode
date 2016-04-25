class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    
    public MyQueue(){
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }
    
    public void inStacktooutStack(){
        while(!inStack.empty()){
            outStack.push(inStack.pop());
        }
    }
    
    public void push(int x) {
           inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
          if(outStack.empty()){
              this.inStacktooutStack();
          }
          
          outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(outStack.empty()){
            this.inStacktooutStack();
        }
        
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}