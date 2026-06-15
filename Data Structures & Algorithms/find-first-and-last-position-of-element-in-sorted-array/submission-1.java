class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int index = binarySearch(nums, target, 0, nums.length - 1);
        if(index == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int left = index;
        while(left >= 0 && nums[left] == nums[index]) {
            left--;
        }
        result[0] = left+1;

        int right = index;
        while(right < nums.length && nums[right] == nums[index]) {
            right++;
        }
        result[1] = right-1;
        return result;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if(right < left) {
            return -1;
        }
        int mid = (left+right)/2;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target) {
            return binarySearch(nums, target, mid+1, right);
        } else {
            return binarySearch(nums, target, left, mid-1);
        }
    }
}