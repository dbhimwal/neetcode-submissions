class Solution {
    Map<Character, List<Character>> phone = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        phone.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        phone.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        phone.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        phone.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        phone.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        phone.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        phone.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        phone.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        letterCombinationsHelper(digits, 0, "");
        return result;
    }

    public void letterCombinationsHelper(String digits, int l, String currentString) {
        if(l == digits.length()) {
            if(currentString.length() > 0) {
                result.add(currentString);
            }
            return;
        }

        List<Character> possibleCharacters = phone.get(digits.charAt(l));

        for(Character c : possibleCharacters) {
            String anotherString = currentString + c;
            letterCombinationsHelper(digits, l+1, anotherString);
        }

        return;
    }

}
