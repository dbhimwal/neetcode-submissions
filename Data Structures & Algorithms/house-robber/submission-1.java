class Solution {
    public int rob(int[] nums) {
        int currentHouses = 0;
        int notCurrentHouses = 0;
        for(int i = 0; i < nums.length; i++) {
            int previousHouses = currentHouses;
            currentHouses = notCurrentHouses + nums[i];
            notCurrentHouses = Math.max(notCurrentHouses, previousHouses);
        }
        return Math.max(currentHouses, notCurrentHouses);
    }
}
