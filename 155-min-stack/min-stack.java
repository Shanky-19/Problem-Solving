class MinStack {

    LinkedList<Long> stack;
    long minElement;

    public MinStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        if(stack.size() == 0) {
            stack.push((long)val);
            minElement = val;
        } else {
            if(val >= minElement) {
                stack.push((long)val);
            } else {
                long tamperedValue = 2L*val-minElement;
                minElement = val;
                stack.push(tamperedValue);
            }
        }
    }
    
    public void pop() {
        if(stack.peek() < minElement) {
            // encountered tampered value
            long tamperedValue = stack.peek();
            minElement = 2*minElement - tamperedValue;
        }
        stack.pop();
        
    }
    
    public int top() {
        long top = stack.peek();
        if(top < minElement) {
            return (int) minElement;
        } else {
            return (int)top;
        }
    }
    
    public int getMin() {
        return (int) minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */