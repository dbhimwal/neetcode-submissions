class Solution {
    public int findMin(int[] nums) {
        return midHelper(nums, 0, nums.length - 1);
    }

    public int midHelper(int[] nums, int l, int r) {
        // System.out.println(l + " - " + r);
        int mid = l + (r - l)/2;

        if(r == l) {
            return nums[l];
        }

        if(nums[r] < nums[mid]) {
            return midHelper(nums, mid + 1, r);
        } else {
            return midHelper(nums, l, mid);
        }
    }
}
