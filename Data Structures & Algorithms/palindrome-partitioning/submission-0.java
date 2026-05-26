class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>());
        return result;
    }

    public void partitionHelper(String s, int l, List<String> currentList) {
        if(l == s.length()) {
            // currentList.add(Character.toString(s.charAt(l)));
            // df.set(l, new ArrayList<>(Arrays.asList(s.charAt(l))));
            result.add(new ArrayList<>(currentList));
            return;
        }

        String currentString = "";
        for(int i = l; i < s.length(); i++) {
            currentString += s.charAt(i);
            if(isPalindorme(currentString)) {
                currentList.add(currentString);
                partitionHelper(s, i + 1, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
        return;
    }

    public boolean isPalindorme(String s) {
        for(int j = 0; j < s.length(); j++) {
            if(s.charAt(j) != s.charAt(s.length() - j - 1)) {
                return false;
            }
        }
        return true;
    }
}
