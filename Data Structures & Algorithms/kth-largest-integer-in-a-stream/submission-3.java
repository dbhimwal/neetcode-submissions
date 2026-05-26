class KthLargest {
    PriorityQueue<Integer> candiates;
    Integer threshold;

    public KthLargest(int k, int[] nums) {
        candiates = new PriorityQueue<>();
        threshold = k;
        for (int i = 0; i < nums.length; i++) {
            if(candiates.size() < k) {
                candiates.add(nums[i]);
            } else if(candiates.peek() < nums[i]) {
                candiates.poll();
                candiates.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(candiates.size() < threshold) {
            candiates.add(val);
        } else if(candiates.peek() < val) {
            candiates.poll();
            candiates.add(val);
        }
        return candiates.peek();       
    }
}
