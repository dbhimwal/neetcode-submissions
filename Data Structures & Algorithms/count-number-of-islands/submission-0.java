class Solution {
    private class Position {
        int x;
        int y;

        Position(int i, int j) {
            x = i;
            y = j;
        }
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        boolean[][] covered = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    if(covered[i][j]) {
                        continue;
                    }
                    coverIsland(grid, new Position(i, j), covered);
                    result++;
                }
            }
        }
        return result;
    }

    private void coverIsland(char[][] grid, Position p,boolean[][] covered) {
        Queue<Position> toexplore = new ArrayDeque();
        toexplore.add(p);
        while(!toexplore.isEmpty()) {
            Position currentPosition = toexplore.poll();
            if(covered[currentPosition.x][currentPosition.y]) {
               continue; 
            }
            covered[currentPosition.x][currentPosition.y] = true;
            if(currentPosition.x > 0 && grid[currentPosition.x - 1][currentPosition.y] == '1') {
                toexplore.add(new Position(currentPosition.x - 1, currentPosition.y));
            }
            if(currentPosition.x < grid.length - 1 && grid[currentPosition.x + 1][currentPosition.y] == '1') {
                toexplore.add(new Position(currentPosition.x + 1, currentPosition.y));
            }
            if(currentPosition.y > 0 && grid[currentPosition.x][currentPosition.y - 1] == '1') {
                toexplore.add(new Position(currentPosition.x, currentPosition.y - 1));
            }
            if(currentPosition.y < grid[0].length - 1 && grid[currentPosition.x][currentPosition.y + 1] == '1') {
                toexplore.add(new Position(currentPosition.x, currentPosition.y + 1));
            }
        }
    }
}
