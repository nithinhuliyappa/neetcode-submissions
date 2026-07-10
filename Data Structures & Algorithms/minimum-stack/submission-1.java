class MinStack {
    Stack<Integer> stk;
    Stack<Integer> mStk;

    public MinStack() {
        this.stk = new Stack<>();
        this.mStk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(mStk.isEmpty() || val <= mStk.peek()){
            mStk.push(val);
        }
    }
    
    public void pop() {
        int val = stk.pop();
        if(mStk.peek() == val){
            mStk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return mStk.peek();
    }
}
