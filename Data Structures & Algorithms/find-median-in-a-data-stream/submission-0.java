class MedianFinder {
    PriorityQueue<Integer> small; //maxHeap
    PriorityQueue<Integer> large; //minHeap
    
    public MedianFinder() {
        small = new PriorityQueue<>((a,b)-> b-a);    
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);

        large.offer(small.poll());

        if(large.size() > small.size()){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {

        if(small.size() > large.size()){
            return (double) small.peek();
        }
        
        return (small.peek()+large.peek())/2.0;
        
    }
}
