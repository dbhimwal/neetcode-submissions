class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length);
    }
    public int searchHelper(int[] nums, int target, int left, int right) {
        if(right <= left) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if(target < nums[mid]) {
            return searchHelper(nums, target, left, mid);
        } else if(target > nums[mid]) {
            return searchHelper(nums, target, (mid + 1), right);
        } else {
            return mid;
        }
    }
}
