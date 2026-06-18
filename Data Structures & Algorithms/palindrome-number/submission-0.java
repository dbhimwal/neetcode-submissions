class Solution {
    public boolean isPalindrome(int x) {
        Integer n = x;
        String num = n.toString();
        int l = 0;
        int r = num.length() - 1;
        while(l < r) {
            if(num.charAt(l) != num.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}