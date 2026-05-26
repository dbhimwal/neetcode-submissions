class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> availableFreq = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(availableFreq.containsKey(c)) {
                availableFreq.put(c, availableFreq.get(c) + 1);
            } else {
                availableFreq.put(c, 1);
            }
        }

        HashMap<Character, Integer> workingFreq = new HashMap<>(availableFreq);
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int startIndex = 0;

        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(workingFreq.containsKey(c)) {
                int freq = workingFreq.get(c);
                if(freq == 1) {
                    workingFreq.remove(c);
                    if(workingFreq.size() == 0) {
                        return true;
                    }
                } else {
                    workingFreq.put(c, freq - 1);
                }
                if (!charIndex.containsKey(c)) {
                    charIndex.put(c, i);
                }
            } else {
                if(charIndex.containsKey(c)) {
                    for(int j = startIndex; j < charIndex.get(c); j++) {
                        if(workingFreq.containsKey(s2.charAt(j))) {
                            workingFreq.put(s2.charAt(j), workingFreq.get(s2.charAt(j)) + 1);
                        } else {
                            workingFreq.put(s2.charAt(j), 1);
                        }
                    }
                    startIndex = charIndex.get(c) + 1;
                } else {
                    workingFreq = new HashMap<>(availableFreq);
                    charIndex = new HashMap<>();
                    startIndex = i + 1;
                }
            }
        }
        return false;
    }
}
