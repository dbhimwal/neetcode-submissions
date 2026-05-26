class Solution {
    public int findDuplicate(int[] nums) {
        long flagNumber = 0;
        for(int num: nums) {
            if((flagNumber & 1L << (num-1)) != 0) {
                return num;
            }
            flagNumber = flagNumber | 1 << (num -1);
        }

        return -1;
    }
}
