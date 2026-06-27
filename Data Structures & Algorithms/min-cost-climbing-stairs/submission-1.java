class Solution {
    int[] price;
    public int minCostClimbingStairs(int[] cost) {
        price = new int[cost.length];
        Arrays.fill(price, -1);
        return Math.min(climbingCost(cost, 0), climbingCost(cost, 1));
    }

    private int climbingCost(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        if(price[index] != -1) {
            return price[index];
        }
        price[index] = cost[index] + Math.min(climbingCost(cost, index+1), climbingCost(cost, index+2));
        return price[index];
    }
}
