class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int cntr = 0;

        for(int i = 0; i < len; i++) {
            //remove the elements out side the window
            while(!queue.isEmpty() && queue.peekFirst()<=(i-k))
                queue.pollFirst();

            //Elements no longer can be a candidate
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            
            queue.addLast(i);
            
            //populate the res
            if(i>=(k-1))
                res[cntr++] = nums[queue.peekFirst()];
        
        }
        return res;
        
    }
}
