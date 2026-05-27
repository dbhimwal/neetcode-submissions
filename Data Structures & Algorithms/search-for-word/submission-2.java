class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(dfs(i, j, board, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int positionInWord, boolean[][] visited) {
        if(positionInWord == word.length() - 1) {
            return true;
        }
        if((i < board.length - 1) && (!visited[i+1][j]) && (board[i+1][j] == word.charAt(positionInWord + 1))) {
            visited[i+1][j] = true;
            if(dfs(i+1, j, board, word, positionInWord+1, visited)) {
                return true;
            }
            visited[i+1][j] = false;
        }
        if((i > 0) && (!visited[i-1][j]) && (board[i-1][j] == word.charAt(positionInWord + 1))) {
            visited[i-1][j] = true;
            if(dfs(i-1, j, board, word, positionInWord+1, visited)) {
                return true;
            }
            visited[i-1][j] = false;
        }
        if((j < board[i].length - 1) && (!visited[i][j+1]) && (board[i][j+1] == word.charAt(positionInWord + 1))) {
            visited[i][j+1] = true;
            if(dfs(i, j+1, board, word, positionInWord+1, visited)) {
                return true;
            }
            visited[i][j+1] = false;
        }
        if((j > 0) && (!visited[i][j-1]) && (board[i][j-1] == word.charAt(positionInWord + 1))) {
            visited[i][j-1] = true;
            if(dfs(i, j-1, board, word, positionInWord+1, visited)) {
                return true;
            }
            visited[i][j-1] = false;
        }
        return false;
    }
}
