class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        
        for(int num : nums)
            set.add(num);

        for(int num : nums) {
            //1. find the starting num
            if(!set.contains(num-1)){
                int current = num;
                int currLen = 1;
                while(set.contains(++current)){
                    currLen++;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }

        return maxLen;
        
    }
}
