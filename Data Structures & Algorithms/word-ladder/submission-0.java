class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> currentWords = new ArrayDeque();
        Set<String> covered = new HashSet<>();
        int distance = 1;
        
        currentWords.add(beginWord);

        while(!currentWords.isEmpty()) {
            Queue<String> nextWords = new ArrayDeque();

            while(!currentWords.isEmpty()) {
                String currentWord = currentWords.poll();
                covered.add(currentWord);
                
                for(String word : wordList) {
                    if (covered.contains(word)) {
                        continue;
                    }
                    if (distance(word, currentWord) == 1) {
                        if(word.equals(endWord)) {
                            return distance + 1;
                        }
                        nextWords.add(word);
                    }
                }
            }
            distance++;
            currentWords = nextWords;
            // System.out.println(currentWords);
        }
        return 0;
    }

    private int distance(String word1, String word2) {
        int result = 0;
        if(word1.length() != word2.length()) {
            return -1;
        }
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}
