class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int zeroIndex = searchZero(nums, 0, nums.length);
        if(zeroIndex == nums.length) {
            zeroIndex--;
        }
        if(nums[zeroIndex] > 0) {
            zeroIndex--;
        }
        int negativeIndex = zeroIndex;
        int positiveIndex = zeroIndex + 1;
        int index = 0;
        while(negativeIndex >= 0 || positiveIndex < nums.length) {
            int negativeValue = Integer.MAX_VALUE;
            int positiveValue = Integer.MAX_VALUE;
            if(negativeIndex >= 0) {
                System.out.println(nums[negativeIndex]);
                negativeValue = nums[negativeIndex] * nums[negativeIndex];
            }
            if(positiveIndex < nums.length) {
                positiveValue = nums[positiveIndex] * nums[positiveIndex];
            }
            if(negativeValue < positiveValue) {
                result[index] = negativeValue;
                index++;
                negativeIndex--;
            } else {
                result[index] = positiveValue;
                index++;
                positiveIndex++;
            }
        }
        return result;
    }

    private int searchZero(int[] nums, int start, int end) {
        if(start >= end - 1) {
            return start;
        }
        int mid = (start + end)/2;
        if(nums[mid] == 0) {
            return mid;
        } else if(nums[mid] > 0) {
            return searchZero(nums, start, mid);
        } else {
            return searchZero(nums, mid + 1, end);
        }
    }
}