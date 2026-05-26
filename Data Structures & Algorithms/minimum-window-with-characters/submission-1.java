class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> t_frequency = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(t_frequency.containsKey(c)) {
                t_frequency.put(c, t_frequency.get(c) + 1);
            } else {
                t_frequency.put(c, 1);
            }
        }

        List<Integer> indexes = new LinkedList<>();
        Map<Character, Integer> s_frequency = new HashMap<>();
        Map<Character, Integer> working_frequency = new HashMap<>(t_frequency);
        String result = "";
        String possibleResult = "";

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!t_frequency.containsKey(c)) {
                continue;
            }
            indexes.add(i);
            if(working_frequency.containsKey(c)) {
                int freq = working_frequency.get(c);
                if(freq == 1) {
                    working_frequency.remove(c);
                    if(working_frequency.isEmpty()) {
                        possibleResult = s.substring(indexes.get(0), i + 1);
                        if(result == "" || (i + 1 - indexes.get(0)) < result.length()) {
                            result = s.substring(indexes.get(0), i + 1);;
                        }
                    }
                } else {
                    working_frequency.put(c,freq -1);
                }
            } else if(c == s.charAt(indexes.get(0))) {
                indexes.remove(0);
                i = indexes.get(0) - 1;
                working_frequency = new HashMap<>(t_frequency);
                indexes = new LinkedList<>();
            }
        }
        return result;
    }
}
