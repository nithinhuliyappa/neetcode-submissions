class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums)
            set.add(num);

        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            int len = 1;
            int num = nums[i];
            if (!set.contains(num-1)) {
                while(set.contains(num+len)){
                    len++;
                }
                count = Math.max(count, len);
            }
        }
        return count;
    }
}
