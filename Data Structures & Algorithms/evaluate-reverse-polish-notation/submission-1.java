class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for(String tkn : tokens) {
            if(tkn.equals("+") || tkn.equals("-") || tkn.equals("*") || tkn.equals("/")){
                int right = stk.pop();
                int left = stk.pop();
                switch(tkn) {
                    case "+":
                        stk.push(left+right);
                        break;
                    case "-":
                        stk.push(left-right);
                        break;
                    case "*":
                        stk.push(left*right);
                        break;
                    case "/":
                        stk.push(left/right);
                        break;
                    default:
                        break;
                }
            }
            else{
                stk.push(Integer.parseInt(tkn));
            }
        }
        return stk.pop();
    }
}
