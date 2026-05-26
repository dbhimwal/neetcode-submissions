class Solution {
    public int trap(int[] height) {
        int[] maxHeightToLeft = new int[height.length];
        int[] maxHeightToRight = new int[height.length];

        int maxHeightSoFar = 0;
        for(int i = 0; i < height.length; i++) {
            maxHeightToLeft[i] = maxHeightSoFar;
            if(height[i] > maxHeightSoFar) {
                maxHeightSoFar = height[i];
            }
        }
        maxHeightSoFar = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            maxHeightToRight[i] = maxHeightSoFar;
            if(height[i] > maxHeightSoFar) {
                maxHeightSoFar = height[i];
            }
        }

        int waterTrapped = 0;
        for(int i = 0; i < height.length; i++) {
            int minHeight = Math.min(maxHeightToLeft[i], maxHeightToRight[i]);
            if(minHeight - height[i] > 0) {
                waterTrapped += minHeight - height[i];
                System.out.println(waterTrapped);
            }
        }
        return waterTrapped;
    }
}
