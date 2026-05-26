class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int n : nums) {
            numbers.add(n);
        }
        int max = 0;

        for(Integer n : numbers) {
            int length = 1;
            if(numbers.contains(n-1)) {
                continue;
            } else {
                int currentNumber = n+1;
                while(numbers.contains(currentNumber)) {
                    length++;
                    currentNumber++;
                }
            }
            if(length > max) {
                max = length;
            }
        }
        return max;
    }
}
