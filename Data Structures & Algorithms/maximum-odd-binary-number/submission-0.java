class Solution {
    public String maximumOddBinaryNumber(String s) {
        int length = s.length();
        int oneCount = 0;
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == '1') {
                oneCount += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < oneCount; i++) {
            sb.append('1');
        }
        for(int i = 0; i < s.length() - oneCount; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}