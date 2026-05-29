class Solution {
    public int appendCharacters(String s, String t) {
        Map<Character, List<Integer>> characterIndex = new HashMap<>();

        int sPosition = 0;
        int tPosition = 0;

        while(sPosition < s.length() && tPosition < t.length()) {
            if(s.charAt(sPosition) == t.charAt(tPosition)) {
                sPosition++;
                tPosition++;
            } else {
                sPosition++;
            }
        }

        return t.length() - tPosition;
    }
}