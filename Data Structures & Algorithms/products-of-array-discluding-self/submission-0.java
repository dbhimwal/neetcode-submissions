class Solution {
    public int[] productExceptSelf(int[] nums) {        
        int[] output = new int[nums.length];
        int product = 1;
        int zeroIndex = -1;
        int productWithoutZero = 1;
        boolean allZero = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if (zeroIndex != -1) {
                    allZero = true;
                }
                zeroIndex = i;
                productWithoutZero *= 1;
            } else {
                productWithoutZero *= nums[i];
            }
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(allZero) {
                output[i] = 0;
            } else {
                if(zeroIndex == i) {
                    output[i] = productWithoutZero;
                } else {
                    output[i] = product/nums[i];
                }
            }
        }       
        return output; 
    }
}  
