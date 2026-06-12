class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resultEndIndex = m + n - 1;
        int nums1EndIndex = m - 1;
        int nums2EndIndex = n - 1;

        while(nums2EndIndex >= 0) {
            if(nums1EndIndex < 0) {
                nums1[resultEndIndex] = nums2[nums2EndIndex];
                resultEndIndex--;
                nums2EndIndex--;
                continue;
            }
            if(nums1[nums1EndIndex] > nums2[nums2EndIndex]) {
                nums1[resultEndIndex] = nums1[nums1EndIndex];
                resultEndIndex--;
                nums1EndIndex--;
            } else {
                nums1[resultEndIndex] = nums2[nums2EndIndex];
                resultEndIndex--;
                nums2EndIndex--;
            }
        }
    }
}