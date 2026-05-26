class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            boolean[] rowDigits = new boolean[9];
            boolean[] columnDigits = new boolean[9];
            for(int j = 0; j < board.length; j++) {
                if( board[i][j] != '.') {
                    int currentRowDigit = board[i][j] - '1';
                    //System.out.println(currentRowDigit);
                    if(rowDigits[currentRowDigit] == true) {
                        return false;
                    }
                    rowDigits[currentRowDigit] = true;
                }                
                if( board[j][i] != '.') {
                    int currentColumnDigit = board[j][i] - '1';
                    if(columnDigits[currentColumnDigit] == true) {
                        return false;
                    }
                    columnDigits[currentColumnDigit] = true;
                }
            }
        }
        boolean isValid = isValidMatrix(0, 0, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(0, 3, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(0, 6, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(3, 0, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(3, 3, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(3, 6, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(6, 0, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(6, 3, board);
        if (!isValid) {
            return false;
        }
        isValid = isValidMatrix(6, 6, board);
        if (!isValid) {
            return false;
        }
        return true;
    }

    private boolean isValidMatrix(int i, int j, char[][] board) {
        boolean[] digits = new boolean[9];
        for(int row = i; row < i + 3; row++) {
            for(int column = j; column < j + 3; column++) {
                if( board[row][column] != '.') {
                    int currentDigit = board[row][column] - '1';
                    // System.out.println(currentDigit + ":" + row + "," + column);
                    if(digits[currentDigit] == true) {
                        return false;
                    }
                    digits[currentDigit] = true;
                }
            }
        }
        return true;
    }
}
