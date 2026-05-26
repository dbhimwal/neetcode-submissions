class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charPlacement = new HashMap<>();
        int maxSubStringLength = 0;
        String subString = "";
        int startIndex = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charPlacement.containsKey(c)) {
                if(charPlacement.get(c) >= startIndex) {
                    maxSubStringLength = Math.max(maxSubStringLength, subString.length());
                    startIndex = charPlacement.get(c) + 1;
                    System.out.println(subString);
                    subString = s.substring(startIndex, i);
                }
            }
            subString += c;
            charPlacement.put(c, i);
        }
        return Math.max(maxSubStringLength, subString.length());
    }
}
