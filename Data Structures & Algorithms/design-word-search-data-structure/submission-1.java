class WordDictionary {
    class Trie {
        boolean endofWord = false;
        HashMap<Character, Trie> childs = new HashMap<>();
    }
    
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie previous = root;
        for(Character c : word.toCharArray()) {
            if(!previous.childs.containsKey(c)) {
                previous.childs.put(c, new Trie());
            }
            previous = previous.childs.get(c);
        }
        previous.endofWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, Trie currentRoot, int leftIndex) {
        if(currentRoot == null) {
            return false;
        }
        if(leftIndex == word.length()) {
            return currentRoot.endofWord;
        }
        if(currentRoot.childs.containsKey(word.charAt(leftIndex))) {
            return searchHelper(word, currentRoot.childs.get(word.charAt(leftIndex)), leftIndex+1);
        }

        if(word.charAt(leftIndex) == '.') {
            for(Map.Entry<Character, Trie> child : currentRoot.childs.entrySet()) {
                if(searchHelper(word, child.getValue(), leftIndex+1)) {
                    return true;
                }
            }
        }
        return false;        
    }
}
