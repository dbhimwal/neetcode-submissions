class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> freqInS1 = new HashMap<>();
        for(Character c : s1.toCharArray()) {
            freqInS1.put(c, freqInS1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> freqInS2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            Character c = s2.charAt(i);
            freqInS2.put(c, freqInS2.getOrDefault(c, 0) + 1);
        }
        if(areMapSame(freqInS1, freqInS2)) {
            return true;
        }

        for(int l = 0; l < s2.length() - s1.length(); l++) {
            Character c = s2.charAt(l + s1.length());
            int f = freqInS2.get(s2.charAt(l));
            if( f == 1 ) {
                freqInS2.remove(s2.charAt(l));
            } else {
                freqInS2.put(s2.charAt(l), f - 1);
            }
            freqInS2.put(c, freqInS2.getOrDefault(c, 0) + 1);
            if(areMapSame(freqInS1, freqInS2)) {
                return true;
            }
        }
        return false;
    }
    private boolean areMapSame(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if(map1.size() != map2.size()) {
            return false;
        }
        for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey()) && map2.get(entry.getKey()) == entry.getValue()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
