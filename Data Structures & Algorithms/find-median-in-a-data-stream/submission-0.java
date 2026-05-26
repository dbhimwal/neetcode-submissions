class MedianFinder {

    private Queue<Integer> smallHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if (
            smallHeap.size() - maxHeap.size() > 1 ||
            !maxHeap.isEmpty() &&
            smallHeap.peek() > maxHeap.peek()
        ) {
            maxHeap.add(smallHeap.poll());
        }
        if (maxHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() == maxHeap.size()) {
            return (double) (maxHeap.peek() + smallHeap.peek()) / 2;
        } else if (smallHeap.size() > maxHeap.size()) {
            return (double) smallHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }        
    }
}
