class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> occurances = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if(occurances.containsKey(element)) {
                return true;
            }
            occurances.put(element, true);
        }
        return false;
    }
}