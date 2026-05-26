class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weights = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int i = 0; i < stones.length; i++) {
            weights.add(stones[i]);
        }
        
        while(weights.size() > 1) {
            int weight1 = weights.poll();
            int weight2 = weights.poll();
            weights.add(weight1 - weight2);
        }
        return weights.peek();
    }
}
