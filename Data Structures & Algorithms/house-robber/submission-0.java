class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for(int num: nums){
           int cur = Math.max(prev1, num+prev2);
           prev2 = prev1;
           prev1 = cur; 
        }

        return prev1;
    }
}
