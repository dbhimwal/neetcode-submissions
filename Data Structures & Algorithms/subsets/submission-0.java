class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsetsHelper(nums, 0);
    }

    public List<List<Integer>> subsetsHelper(int[] nums, int l) {
        if (l == nums.length) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        List<List<Integer>> remainingSubset =  subsetsHelper(nums, l + 1);
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> subset : remainingSubset) {
            result.add(new ArrayList<>(subset));
            subset.add(nums[l]);
            result.add(subset);
        }
        return result;
    }

}
