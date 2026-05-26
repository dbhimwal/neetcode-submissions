class Solution {
    List<List<String>> result;
    String UNFILLED_ROW = "";
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        List<List<Boolean>> attack = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            attack.add(new ArrayList<>());
            for(int j = 0; j < n; j++) {
                attack.get(i).add(false);
            }
            UNFILLED_ROW += ".";
        }

        solveNQueensHelper(n, new ArrayList<>(), attack);
        return result;
    }

    public void solveNQueensHelper(int n, List<String> placement, List<List<Boolean>> board) {
        if(placement.size() == n) {
            result.add(new ArrayList<>(placement));
            return;
        }
        int currentRow = placement.size();
        String notation = UNFILLED_ROW;
        for(int i = 0; i < n; i++) {
            if(board.get(currentRow).get(i)) {
                continue;
            }
            // System.out.println("Placing Q: " + currentRow + "," + i);
            notation = notation.substring(0, i) + "Q" +notation.substring(i + 1);
            placement.add(notation);
            List<List<Boolean>> tempBoard = placeQ(board, currentRow, i);
            solveNQueensHelper(n, placement, tempBoard);
            placement.remove(placement.size() - 1);
            notation = UNFILLED_ROW;
        }
        return;
    }

    public List<List<Boolean>> placeQ(List<List<Boolean>> board, int row, int column) {

        List<List<Boolean>> result = new ArrayList<>();
        for (List<Boolean> boardRow : board) {
            result.add(new ArrayList<>(boardRow));
        }
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.size(); j++) {
                if(Math.abs(i - row) == Math.abs(j - column)) {
                    result.get(i).set(j, true);
                }
            }
            result.get(row).set(i, true);
            result.get(i).set(column, true);
        }
        return result;
    }
}
