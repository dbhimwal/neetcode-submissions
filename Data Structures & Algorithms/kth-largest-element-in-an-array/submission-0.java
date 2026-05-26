class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> elements = new PriorityQueue();
        for(int i = 0; i < nums.length; i++) {
            if(elements.size() < k) {
                elements.add(nums[i]);
            } else if (elements.peek() < nums[i]) {
                elements.poll();
                elements.add(nums[i]);
            }
        }
        return elements.peek();
    }
}
