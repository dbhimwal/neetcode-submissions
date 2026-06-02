class Solution {
    public int climbStairs(int n) {
        int[] waysToClimb = new int[n+1];
        for(int i = 0; i <= n; i++) {
            if(i == 0) {
                waysToClimb[i] = 0;
                continue;
            }
            if(i == 1) {
                waysToClimb[i] = 1;
                continue;
            }
            if(i == 2) {
                waysToClimb[i] = 2;
                continue;
            }
            waysToClimb[i] = waysToClimb[i-1] + waysToClimb[i-2];
        }
        return waysToClimb[n];
    }
}
