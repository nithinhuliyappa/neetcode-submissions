class Solution {
    public int findDuplicate(int[] nums) {
        
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx-1] < 0){
                res = Math.abs(nums[i]);
                break;
            }
            nums[idx-1] *= -1;
        }
        return res;
    }
}
