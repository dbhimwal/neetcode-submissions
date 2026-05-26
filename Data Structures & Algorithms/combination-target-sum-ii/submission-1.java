class Solution {

    Set<List<Integer>> finalOutput;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        finalOutput = new HashSet<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, new ArrayList<>());

        return new ArrayList<>(finalOutput);        
    }


    public void combinationSumHelper(int[] nums, int target, int l, List<Integer> list) {
        if(target == 0) {
            finalOutput.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || l == nums.length) {
            return;
        }

        combinationSumHelper(nums, target, l+1, list);
        list.add(nums[l]);
        combinationSumHelper(nums, target - nums[l], l+1, list);
        list.remove(list.size() - 1);

        return;
    }
}