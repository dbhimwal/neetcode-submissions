class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int first_num = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int second_num = nums[j];
                if(first_num + second_num == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}

