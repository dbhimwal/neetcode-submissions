class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++) {
            int firstNumber = nums[i];
            if(firstNumber > 0) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = firstNumber + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> response = new ArrayList<>();
                    response.add(firstNumber);
                    response.add(nums[j]);
                    response.add(nums[k]);
                    result.add(response);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
