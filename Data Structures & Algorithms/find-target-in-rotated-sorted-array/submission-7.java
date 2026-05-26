class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length);
    }

    public int searchHelper(int[] nums, int target, int l, int r) {
        System.out.println(l + " - " + r);
        if(r - l <= 2) {
            if (target == nums[l]) {
                return l;
            } else if ((nums.length > l + 1) && (target == nums[l + 1])) {
                return l + 1;
            }
            return -1;
        }

        int mid = l + (r - l)/2;
        if(target == nums[mid]) {
            return mid;
        }
        if(nums[r - 1] < nums[mid]) {
            // smallest element is on right side
            if(target < nums[r - 1]) {
                return searchHelper(nums, target, mid, r);
            } else if (target > nums[r - 1]){
                return searchHelper(nums, target, l, mid);
            } else {
                return r - 1;
            }
        } else {
            // smallest element is on left side
            if((target <= nums[r - 1]) && (target > nums[mid])) {
                return searchHelper(nums, target, mid, r);
            } else {
                return searchHelper(nums, target, l, mid);
            }
        }
    }
}
