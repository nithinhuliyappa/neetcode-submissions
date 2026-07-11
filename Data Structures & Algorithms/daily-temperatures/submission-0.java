class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stk = new ArrayDeque<>();
        int len = temperatures.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++){
            int temp = temperatures[i];
            while(!stk.isEmpty() && temp > temperatures[stk.peek()]){
                int prevIdx = stk.pop();
                res[prevIdx] = i - prevIdx;
            } 
            stk.push(i);
        }
        
        return res;
    }
}
