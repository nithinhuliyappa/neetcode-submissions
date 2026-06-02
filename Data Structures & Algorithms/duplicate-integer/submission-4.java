class Solution {
    
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.isEmpty() || !set.contains(num))
                set.add(num);
            else
                return true;
        }

        return false;
    }
}