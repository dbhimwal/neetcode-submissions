class Solution {
    class Position {
        int x;
        int y;

        Position(int i, int j) {
            x = i;
            y = j;
        }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] fill = new boolean[rows][columns];
        Queue<Position> toExplore = new ArrayDeque<>();

        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') {
                toExplore.add(new Position(i, 0));
            }
            if(board[i][columns - 1] == 'O') {
                toExplore.add(new Position(i, columns - 1));
            }
        }
        for(int j = 0; j < columns; j++) {
            if(board[0][j] == 'O') {
                toExplore.add(new Position(0, j));
            }
            //System.out.println(rows + "," + j + ":" + board[rows - 1][j]);
            if(board[rows - 1][j] == 'O') {
                //System.out.println("adding");
                toExplore.add(new Position(rows - 1, j));
            }
        }

        while(!toExplore.isEmpty()) {
            System.out.println(toExplore);
            Position p = toExplore.poll();
            if(fill[p.x][p.y]) {
                continue;
            }
            fill[p.x][p.y] = true;
            if(p.x > 0 && board[p.x - 1][p.y] == 'O') {
                toExplore.add(new Position(p.x - 1, p.y));
            }
            if(p.y > 0 && board[p.x][p.y - 1] == 'O') {
                toExplore.add(new Position(p.x, p.y - 1));
            }
            if((p.x < (rows - 1)) && board[p.x + 1][p.y] == 'O') {
                toExplore.add(new Position(p.x + 1, p.y));
            }
            if((p.y < (columns - 1)) && board[p.x][p.y + 1] == 'O') {
                toExplore.add(new Position(p.x, p.y + 1));
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(board[i][j] == 'O' && !fill[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }
}
