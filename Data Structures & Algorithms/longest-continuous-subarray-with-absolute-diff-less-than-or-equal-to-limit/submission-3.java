class Solution {
    class NumPosition {
        int num;
        int index;

        NumPosition(int n, int i) {
            num = n;
            index = i;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<NumPosition> minHeap = new PriorityQueue<>((a, b) -> (a.num - b.num));
        PriorityQueue<NumPosition> maxHeap = new PriorityQueue<>((a, b) -> (b.num - a.num));

        minHeap.add(new NumPosition(nums[0], 0));
        maxHeap.add(new NumPosition(nums[0], 0));

        int maxLength = 1;

        int leftIndex = 0;
        int rightIndex = 1;
        while(rightIndex < nums.length) {
            while(minHeap.peek().index < leftIndex) {
                minHeap.poll();
            }
            while(maxHeap.peek().index < leftIndex) {
                maxHeap.poll();
            }

            if((Math.abs(minHeap.peek().num - nums[rightIndex]) > limit) || (Math.abs(maxHeap.peek().num - nums[rightIndex]) > limit)) {
                System.out.println(leftIndex + "-" + rightIndex);
                maxLength = Math.max(maxLength, rightIndex - leftIndex);
                leftIndex++;
                minHeap.add(new NumPosition(nums[rightIndex],rightIndex ));
                maxHeap.add(new NumPosition(nums[rightIndex],rightIndex ));
            } else {
                minHeap.add(new NumPosition(nums[rightIndex],rightIndex ));
                maxHeap.add(new NumPosition(nums[rightIndex],rightIndex ));
                rightIndex++;
            }
        }
        System.out.println(leftIndex + "-" + rightIndex);
        return Math.max(maxLength, rightIndex - leftIndex);
    }
}