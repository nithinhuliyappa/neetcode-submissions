class Solution {

    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length-1;

        while(left<right){
            int leftMax = heights[left];
            int rightMax = heights[right];

            int curArea = (right - left) * Math.min(leftMax, rightMax);

            maxArea = Math.max(maxArea, curArea);

            if(leftMax < rightMax)
                left++;
            else
                right--;
        }
        
        return maxArea;
    }
}
