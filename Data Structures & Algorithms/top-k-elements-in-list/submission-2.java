class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();

        for(int num : nums) {
            fre.put(num, fre.getOrDefault(num, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];

        for(int i = 0; i<buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : fre.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length-1; i > 0 && index < k; i--){
            for(int num : buckets[i]){
                res[index++] = num;
                if(index == k)
                    return res;
            }
        }
        return res;
    }
}
