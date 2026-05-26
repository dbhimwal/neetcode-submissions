class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> sequences = new HashMap<>();
        int longestSequence = 0;
        for(int i = 0; i < nums.length; i++) {
            sequences.put(nums[i], 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(sequences.containsKey(nums[i] - 1)) {
                continue;
            }
            int number = nums[i];
            int length = 0;
            while(sequences.containsKey(number)) {
                number += 1;
                length += 1;
            }
            if(length > longestSequence) {
                longestSequence = length;
            }
        }
        return longestSequence;
    }
}
