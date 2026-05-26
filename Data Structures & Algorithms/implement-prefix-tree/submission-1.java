class PrefixTree {
    class Trie {
        boolean end;
        Map<Character, Trie> childs;

        Trie() {
            end = false;
            childs = new HashMap<>();
        }

        Trie(boolean b) {
            end = b;
            childs = new HashMap<>();
        }
    }

    Trie root;

    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie previous = root;
        for(Character c : word.toCharArray()) {
            if (!previous.childs.containsKey(c)) {
                Trie current = new Trie(false);
                previous.childs.put(c, current);
            }
            previous = previous.childs.get(c);
        }
        previous.end = true;
    }

    public boolean search(String word) {
        Trie previous = root;
        for(Character c : word.toCharArray()) {
            if(previous.childs.containsKey(c)) {
                previous = previous.childs.get(c);
            } else {
                return false;
            }
        }
        return previous.end;
    }

    public boolean startsWith(String prefix) {
        Trie previous = root;
        for(Character c : prefix.toCharArray()) {
            if(previous.childs.containsKey(c)) {
                previous = previous.childs.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
