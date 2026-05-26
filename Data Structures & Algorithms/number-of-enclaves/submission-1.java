class Solution {
    class Position {
        int row;
        int column;

        Position(int x, int y) {
            row = x;
            column = y;
        }
    }
    public int numEnclaves(int[][] grid) {
        int totalLandCells = 0;
        int cellsCovered = 0;
        Queue<Position> covered = new ArrayDeque();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    totalLandCells++;
                    if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
                        covered.add(new Position(i, j));
                        cellsCovered++;
                        grid[i][j] = -1;
                    }
                }
            }
        }

        while(!covered.isEmpty()) {
            Position p = covered.poll();
            if(p.row > 0 && grid[p.row - 1][p.column] == 1) {
                covered.add(new Position(p.row - 1, p.column));
                cellsCovered++;
                grid[p.row - 1][p.column] = -1;
            }
            if(p.row < grid.length - 1 && grid[p.row + 1][p.column] == 1) {
                covered.add(new Position(p.row + 1, p.column));
                cellsCovered++;
                grid[p.row + 1][p.column] = -1;
            }
            if(p.column > 0 && grid[p.row][p.column - 1] == 1) {
                covered.add(new Position(p.row, p.column - 1));
                cellsCovered++;
                grid[p.row][p.column - 1] = -1;
            }
            if(p.column < grid[0].length - 1 && grid[p.row][p.column + 1] == 1) {
                covered.add(new Position(p.row, p.column + 1));
                cellsCovered++;
                grid[p.row][p.column + 1] = -1;
            }
        }
        return totalLandCells - cellsCovered;
    }
}