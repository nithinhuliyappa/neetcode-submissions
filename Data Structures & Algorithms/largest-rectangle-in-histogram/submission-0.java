class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i<=n; i++){
            while(!stk.isEmpty() &&
            (i == n || heights[stk.peek()] >= heights[i])){
                int height = heights[stk.pop()];
                int width = stk.isEmpty() ? i : i - stk.peek() - 1;
                maxArea = Math.max(maxArea, height * width); 
            }
            stk.push(i);
        }
        return maxArea;
    }
}
