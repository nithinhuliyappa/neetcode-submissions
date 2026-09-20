class MinStack {
    record Node(int val, int min) {};
    Deque<Node> stk;
    
    public MinStack() {
        this.stk = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int min = stk.isEmpty() ? val 
        : Math.min(stk.peek().min, val);
        stk.push(new Node(val, min));
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}
