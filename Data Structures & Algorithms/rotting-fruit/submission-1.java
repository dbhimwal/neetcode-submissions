class Solution {
    class Position {
        int x;
        int y;

        Position(int row, int column) {
            x = row;
            y = column;
        }
    }

    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) {
            return -1;
        }
        int freshFruitCount = 0;
        int rottenFruitCount = 0;
        Queue<Position> rottenFruits = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    freshFruitCount++;
                } else if (grid[i][j] == 2) {
                    rottenFruitCount++;
                    rottenFruits.add(new Position(i, j));
                }
            }
        }

        int minutes = 0;
        if(freshFruitCount == 0) {
            return minutes;
        }
        while(!rottenFruits.isEmpty()) {
            Queue<Position> nextNodes = new LinkedList<>();
            while(!rottenFruits.isEmpty()) {
                Position currentNode = rottenFruits.poll();
                // System.out.println(currentNode.x + ", " + currentNode.y);
                if((currentNode.x > 0) && (grid[currentNode.x - 1][currentNode.y] == 1)) {
                    freshFruitCount--;
                    grid[currentNode.x - 1][currentNode.y] = 2;
                    nextNodes.add(new Position(currentNode.x - 1, currentNode.y));
                }
                if(currentNode.y > 0 && (grid[currentNode.x][currentNode.y - 1] == 1)) {
                    freshFruitCount--;
                    grid[currentNode.x][currentNode.y - 1] = 2;
                    nextNodes.add(new Position(currentNode.x, currentNode.y - 1));
                }
                if((currentNode.x < (grid.length - 1)) && (grid[currentNode.x + 1][currentNode.y] == 1)) {
                    freshFruitCount--;
                    grid[currentNode.x + 1][currentNode.y] = 2;
                    nextNodes.add(new Position(currentNode.x + 1, currentNode.y));
                }
                if((currentNode.y < (grid[0].length - 1)) && (grid[currentNode.x][currentNode.y + 1] == 1)) {
                    freshFruitCount--;
                    grid[currentNode.x][currentNode.y + 1] = 2;
                    nextNodes.add(new Position(currentNode.x, currentNode.y + 1));
                }
            }
            rottenFruits = nextNodes;
            minutes++;
            if(freshFruitCount == 0) {
                return minutes;
            }
        }

        return -1;
    }
}
