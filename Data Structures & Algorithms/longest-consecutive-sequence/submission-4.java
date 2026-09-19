class Solution {
    public int longestConsecutive(int[] nums) {
        int maxSeq = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);

        for(int num : nums) {
            int curr = num;
            if(!set.contains(num-1)){
                int streak = 1;
                while(set.contains(curr+1)){
                    curr++;
                    streak++;
                }
                maxSeq = Math.max(maxSeq, streak);
            }
        }

        return maxSeq;
    }
}
