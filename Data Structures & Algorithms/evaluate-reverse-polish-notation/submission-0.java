class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();

        for(String tkn : tokens){
            if(tkn.equals("+") || tkn.equals("-") || tkn.equals("*") || tkn.equals("/")){
                int right = stk.pop();
                int left = stk.pop();
                switch(tkn){
                    case "+":
                        stk.push(left + right);
                        break;
                    case "-":
                        stk.push(left - right);
                        break;
                    case "*":
                        stk.push(left * right);
                        break;
                    case "/":
                        stk.push(left / right);
                        break;
                }
            } else {
                stk.push(Integer.parseInt(tkn));
            }
        }

        return stk.peek();
        
    }
}
