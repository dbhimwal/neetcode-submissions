class Solution {
    public int minimumDifference(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - k; i++) {
            result = Math.min(result, nums[i+k-1] - nums[i]);
        }
        return result;
    }
}