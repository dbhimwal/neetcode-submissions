class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int currentRemainder = sum%k;
            if(remainderMap.containsKey(currentRemainder)) {
                if(i - remainderMap.get(currentRemainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(currentRemainder, i);
            }
        }
        return false;
    }
}