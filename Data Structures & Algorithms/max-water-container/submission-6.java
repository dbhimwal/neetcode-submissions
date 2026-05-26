class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int maxArea = 0;

        while (l < r) {
            int minHeight;
            if(heights[l] <= heights[r]) {
                minHeight = heights[l];
                l++;
            } else {
                minHeight = heights[r];
                r--;
            }
            maxArea = Math.max(maxArea, minHeight*(r - l + 1));

        }
        return maxArea;
    }
}
