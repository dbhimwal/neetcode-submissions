class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(subsetsHelper(nums, 0));
    }

    public Set<List<Integer>> subsetsHelper(int[] nums, int l) {
        if (l == nums.length) {
            Set<List<Integer>> base = new HashSet<>();
            base.add(new ArrayList<>());
            return base;
        }
        Set<List<Integer>> remainingSubset =  subsetsHelper(nums, l + 1);
        Set<List<Integer>> result = new HashSet<>();
        for(List<Integer> subset : remainingSubset) {
            result.add(new ArrayList<>(subset));
            subset.add(nums[l]);
            result.add(subset);
        }
        return result;
    }
}
