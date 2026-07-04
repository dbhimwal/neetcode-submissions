class Solution {
    class Position {
        int row;
        int column;

        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Position> zeros = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    zeros.add(new Position(i, j));
                }
            }
        }

        for(Position p : zeros) {
            int row = p.row;
            int column = p.column;
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
    }
}
