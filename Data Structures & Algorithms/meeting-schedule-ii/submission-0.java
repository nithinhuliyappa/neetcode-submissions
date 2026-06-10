/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b)-> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            if(minHeap.isEmpty()){
                minHeap.add(interval.end);
            } else if (minHeap.peek() > interval.start){
                minHeap.add(interval.end);
            } else {
                minHeap.poll();
                minHeap.add(interval.end);
            }
        }

        return minHeap.size();
    }
}
