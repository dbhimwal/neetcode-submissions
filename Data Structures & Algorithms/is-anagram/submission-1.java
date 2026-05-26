class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> occurances = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            int occurance = 0;
            if(occurances.containsKey(character)) {
                occurance = occurances.get(character);
            }
            occurances.put(character, occurance + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if(!occurances.containsKey(character)) {
                return false;
            }
            int occurance = occurances.get(character);
            if(occurance == 1) {
                occurances.remove(character);
            } else {
                occurances.put(character, occurance - 1);
            }

        }
        if(occurances.size() > 0) {
            return false;
        }
        return true;
    }
}
