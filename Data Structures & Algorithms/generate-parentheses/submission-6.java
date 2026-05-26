class Solution {
    List<List<String>> dp = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");

        generateParenthesisHelper(n);
        return dp.get(n);
    }

    public void generateParenthesisHelper(int n) {
        if(dp.get(n).size() > 0) {
            // System.out.println("for " + n + dp.get(n));
            return;
        }

        for(int i = 0; i < n; i++) {
            generateParenthesisHelper(i);
            generateParenthesisHelper(n - i - 1);
            for(String left : dp.get(i)) {
                for(String right : dp.get(n - i - 1)) {
                    // System.out.println("for " + n + "left: " + left + "right: " + right);
                    dp.get(n).add("(" + left + ")" + right);
                }
            }
            
        }
        return;
    }

}
