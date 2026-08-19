class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> IdxMap = new HashMap<>();

        for (int i = 0;  i < nums.length; i++) {
            int remainder = target - nums[i];

            if(IdxMap.containsKey(remainder))
                return new int[] {IdxMap.get(remainder), i};
            IdxMap.put(nums[i], i);
        }

        return new int[]{0,0};
        
    }
}
