class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i= 0; i<=n; i++){
            while(!stk.isEmpty() && (i==n || heights[i] < heights[stk.peek()])){
                int height = heights[stk.pop()];
                int width = i - (stk.isEmpty() ? -1 : stk.peek()) -1;
                maxArea = Math.max(maxArea, (height*width));
            }
            stk.push(i);
        }

        return maxArea;
    }
}
