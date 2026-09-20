class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0; i <= len; i++) {
            while(!stk.isEmpty() && 
            (i==len || heights[stk.peek()] >= heights[i])){
                int height = heights[stk.pop()];
                int width = i - (stk.isEmpty() ? -1 : stk.peek()) -1;
                maxArea = Math.max(maxArea, height*width);
            }
            stk.push(i);
        }
        return maxArea;
    }
}
