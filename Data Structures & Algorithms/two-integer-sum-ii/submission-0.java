class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int currentSum = numbers[i] + numbers[j];
            if(currentSum > target) {
                j--;
                continue;
            } else if ( currentSum == target) {
                return new int[]{i + 1, j + 1};
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
