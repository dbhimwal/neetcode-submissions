class Solution {
    int[][] memo;
    public int rob(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return Math.max(dp(nums, 0, nums.length-2), dp(nums, 1, nums.length-1));
    }

    public int dp(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (memo[start][end] != -1) {
            return memo[start][end];
        }

        memo[start][end] = Math.max(dp(nums, start+1, end), nums[start] + dp(nums, start+2, end));
        return memo[start][end];
    }
}
