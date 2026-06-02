class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int diff = 0;

        for(int i = 0; i<nums.length; i++) {
            diff = target - nums[i];
            if(set.containsKey(diff))
               return new int[] {set.get(diff), i};
            set.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
