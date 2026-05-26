class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; 
        int j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(!isAlphaNumeric(left)) {
                i++;
                continue;
            }
            if(!isAlphaNumeric(right)) {
                j--;
                continue;
            }
            if(left != right) {
                // System.out.println(s_chars[i] + ":" + s_chars[j] + ":" + i + ":" + j);
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isAlphaNumeric(char c) {
        if ( ((c - 'a' < 26) && (c >= 'a')) || ((c - '0' < 10) && (c >= '0'))) {
            // System.out.println(c - 'a');
            // System.out.println(c - '0');
            return true;
        }
        return false;
    }
}
