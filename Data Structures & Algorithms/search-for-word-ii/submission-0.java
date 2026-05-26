class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> returnVal = new ArrayList<>();
        for(String word : words) {
            if(findWords(board, word)) {
                returnVal.add(word);
            }
        }
        return returnVal;
    }

    public boolean findWords(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    board[i][j] = 'T';
                    boolean returnVal = findWordsHelper(board, word, i, j, 1);
                    board[i][j] = word.charAt(0);
                    if(returnVal) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean findWordsHelper(char[][] board, String word, int i, int j, int l) {
        if(l == word.length()) {
            return true;
        }
        Character c = word.charAt(l);
        if(i > 0 && board[i - 1][j] == c) {
            board[i - 1][j] = 'T';
            boolean returnVal = findWordsHelper(board, word, i - 1, j, l + 1);
            board[i - 1][j] = c;
            if(returnVal) {
                return true;
            }
        }
        if((i < board.length - 1) && board[i + 1][j] == c) {
            board[i + 1][j] = 'T';
            boolean returnVal = findWordsHelper(board, word, i + 1, j, l + 1);
            board[i + 1][j] = c;
            if(returnVal) {
                return true;
            }            
        }
        if(j > 0 && board[i][j - 1] == c) {
            board[i][j - 1] = 'T';
            boolean returnVal = findWordsHelper(board, word, i, j - 1, l + 1);
            board[i][j - 1] = c;
            if(returnVal) {
                return true;
            }            
        }
        if((j < board[0].length - 1) && board[i][j + 1] == c) {
            board[i][j + 1] = 'T';
            boolean returnVal = findWordsHelper(board, word, i, j + 1, l + 1);
            board[i][j + 1] = c;
            if(returnVal) {
                return true;
            }            
        }
        return false;
    }

}
