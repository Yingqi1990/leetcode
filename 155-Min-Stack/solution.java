class MinStack {
    
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    
    public void push(int x) {
        stack.add(x);
        
        if(minStack.isEmpty() || x <= minStack.get(minStack.size() - 1)){
            minStack.add(x); 
        }
        
    }

    public void pop() {
        if(stack.isEmpty()){ 
            return;
        }
        
        int em = stack.get(stack.size() - 1);
        
        if(!minStack.isEmpty() && (em == minStack.get(minStack.size() - 1))){
            minStack.remove(minStack.size() - 1);
        }
        
        stack.remove(stack.size() - 1);
    }

    public int top() {
        if(stack.isEmpty()){
            return 0;
        }
        
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return 0;
        }
        
        return minStack.get(minStack.size() - 1);
    }
}