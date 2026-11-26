class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(idxMap.containsKey(diff)){
                return new int[]{idxMap.get(diff), i};
            }
            idxMap.put(nums[i], i);
        }

        return new int[]{0,0};
    }
}
