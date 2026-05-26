class Solution {
    public int findMin(int[] nums) {
        return midHelper(nums, 0, nums.length);
    }

    public int midHelper(int[] nums, int l, int r) {
        System.out.println(l + " - " + r);
        int mid = l + (r - l)/2;

        if(r - l <= 1) {
            return nums[l];
        }

        if(r - l <= 2) {
            return Math.min(nums[l], nums[r - 1]);
        }

        if((nums[mid - 1] > nums[mid]) && nums[mid] < nums[mid + 1]) {
            return nums[mid];
        }
        if(nums[r - 1] < nums[mid]) {
            return midHelper(nums, mid, r);
        } else {
            return midHelper(nums, l, mid);
        }
    }
}
