class Solution {
    class Position {
        int x;
        int y;

        Position(int row, int column) {
            x = row;
            y = column;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        if(grid.length == 0) {
            return;
        }

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    traverseGrid(grid, i, j);
                }
            }
        }
    }

    private void traverseGrid(int[][] grid, int row, int column) {
        Queue<Position> nodes = new LinkedList<>();
        nodes.add(new Position(row, column));
        int distance = 0;
        while(!nodes.isEmpty()) {
            Queue<Position> nextNodes = new LinkedList<>();
            while(!nodes.isEmpty()) {
                Position currentNode = nodes.poll();
                // System.out.println(currentNode.x + ", " + currentNode.y);
                if(grid[currentNode.x][currentNode.y] >= distance) {
                    grid[currentNode.x][currentNode.y] = distance;
                    if(currentNode.x > 0) {
                        nextNodes.add(new Position(currentNode.x - 1, currentNode.y));
                    }
                    if(currentNode.y > 0) {
                        nextNodes.add(new Position(currentNode.x, currentNode.y - 1));
                    }
                    if(currentNode.x < (grid.length - 1)) {
                        nextNodes.add(new Position(currentNode.x + 1, currentNode.y));
                    }
                    if(currentNode.y < (grid[0].length - 1)) {
                        nextNodes.add(new Position(currentNode.x, currentNode.y + 1));
                    }
                }
            }
            nodes = nextNodes;
            distance++;
        }
    }
}
