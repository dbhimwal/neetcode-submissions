class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> occurances = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!occurances.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}