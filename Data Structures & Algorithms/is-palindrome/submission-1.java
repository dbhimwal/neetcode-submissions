class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; 
        int j = s.length() - 1;
        char[] s_chars = s.toLowerCase().toCharArray();

        while (i < j) {
            if(!isAlphaNumeric(s_chars[i])) {
                i++;
                continue;
            }
            if(!isAlphaNumeric(s_chars[j])) {
                j--;
                continue;
            }
            if(s_chars[i] != s_chars[j]) {
                System.out.println(s_chars[i] + ":" + s_chars[j] + ":" + i + ":" + j);
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isAlphaNumeric(char c) {
        if ( ((c - 'a' < 26) && (c >= 'a')) || ((c - '0' < 10) && (c >= '0'))) {
            System.out.println(c - 'a');
            System.out.println(c - '0');
            return true;
        }
        return false;
    }
}
