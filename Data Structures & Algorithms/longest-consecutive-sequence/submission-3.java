class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> sequences = new HashSet<>(nums.length);
        int longestSequence = 0;
        for(int i = 0; i < nums.length; i++) {
            sequences.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if(sequences.contains(number - 1)) {
                continue;
            }
            int length = 0;
            while(sequences.contains(number)) {
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
