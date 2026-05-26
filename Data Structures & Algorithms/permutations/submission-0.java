class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permuteHelper(nums, 0);
        return result;
    }

    public void permuteHelper(int[] nums, int l) {
        if(l == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
            return;
        }

        for(int i = l; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[l];
            nums[l] = temp;
            permuteHelper(nums, l + 1);
            temp = nums[i];
            nums[i] = nums[l];
            nums[l] = temp;
        }
    }
    
}
