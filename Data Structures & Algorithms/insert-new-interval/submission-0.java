class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i<intervals.length; i++){
            if(intervals[i][1] < newInterval[0]){
                res.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);

        return res.toArray(new int[res.size()][]);

    }
}
