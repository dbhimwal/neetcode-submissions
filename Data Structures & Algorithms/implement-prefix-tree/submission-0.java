class PrefixTree {
    class Trie {
        Character val;
        boolean end;
        Map<Character, Trie> childs;

        Trie() {
            end = false;
            childs = new HashMap<>();
        }

        Trie(Character c, boolean b) {
            val = c;
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
                Trie current = new Trie(c, false);
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
