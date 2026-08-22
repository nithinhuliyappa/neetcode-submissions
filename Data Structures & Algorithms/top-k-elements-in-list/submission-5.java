class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<Integer>[] fBuckets = new List[nums.length+1];
        
        for(int i = 0; i<fBuckets.length; i++){
            fBuckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            fBuckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        
        int count = 0;
        for(int i = fBuckets.length-1; i>=0 && count <k; i--){
            for(int n : fBuckets[i]){
                res[count++] = n;
            }
        }

        return res;
    }
}
