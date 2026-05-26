class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int k = heights.length - 1;
        int maxArea = 0;
        while (i < k) {
            int min;
            if (heights[k] < heights[i]) {
                min = heights[k];
                k--;
            } else {
                min = heights[i];
                i++;
            }
            if(min * (k - i + 1) > maxArea) {
                maxArea = min * (k - i + 1);
            }
        }
        return maxArea;
    }
}
