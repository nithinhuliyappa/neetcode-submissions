class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> freq.get(a)-freq.get(b));

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k)
                pq.poll();
        } 

        int[] res = new int[k];
        for(int i=0 ; i<k ; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
