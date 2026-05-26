class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> equation = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            // System.out.println("Token: " + token);
            // System.out.println(token.equals("+"));
            if ((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))) {
                // System.out.println("Found operator: " + token);
                Integer second = equation.pop();
                Integer first = equation.pop();
                Integer result = 0;
                if(token.equals("+")) {
                    result = first + second;
                }
                if(token.equals("-")) {
                    result = first - second;                    
                }
                if(token.equals("*")) {
                    result = first * second;                    
                }
                if(token.equals("/")) {                    
                    result = first / second;
                }
                equation.push(result);
            } else {
                equation.push(Integer.parseInt(token));
            }
        }
        return equation.pop();
    }
}
