class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        int l = 0;
        int result = 0;

        for(int r = 0; r < nums.length; r++) {
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);

            while (count.size() > k) {
                int integerCount = count.get(nums[l]);
                if(integerCount == 1) {
                    count.remove(nums[l]);
                } else {
                    count.put(nums[l], count.get(nums[l]) - 1);
                }
                l++;                
            }
            result += r - l + 1;
        } 
        return result;
    }

}