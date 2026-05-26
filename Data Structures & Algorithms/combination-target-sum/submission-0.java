class Solution {
    class ValidSum {
        boolean isValid;
        List<Integer> list;

        ValidSum(boolean valid, List<Integer> result) {
            isValid = valid;
            list = result;
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> finalOutput = new ArrayList<>();
        List<ValidSum> sample = combinationSumHelper(nums, target, 0);

        for(ValidSum response : sample) {
            if(response.isValid) {
                finalOutput.add(response.list);
            }
        }
        return finalOutput;
    }

    public List<ValidSum> combinationSumHelper(int[] nums, int target, int l) {
        List<ValidSum> result = new ArrayList<>();
        if(target == 0) {
            result.add(new ValidSum(true, new ArrayList<>()));
            return result;
        }
        if(target < 0 || l == nums.length) {
            result.add(new ValidSum(false, new ArrayList<>()));
            return result;
        }

        List<ValidSum> notIncludingCurrent = combinationSumHelper(nums, target, l+1);
        List<ValidSum> includingCurrent = combinationSumHelper(nums, target - nums[l], l);

        for(ValidSum response : includingCurrent) {
            response.list.add(nums[l]);
        }
        result.addAll(notIncludingCurrent);
        result.addAll(includingCurrent);

        return result;
    }
}
