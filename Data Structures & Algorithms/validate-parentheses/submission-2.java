class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if((c == '(') || (c == '{') || (c == '[')) {
                brackets.push(c);
            }  else {
                if(brackets.isEmpty()) {
                    return false;
                }
                Character lastBracket = brackets.pop();
                if((c == ')') && (lastBracket != '(')) {
                    return false;
                }
                if((c == ']') && (lastBracket != '[')) {
                    return false;
                }
                if((c == '}') && (lastBracket != '{')) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
