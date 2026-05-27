class Solution {
    List<Integer> result;
    public List<Integer> spiralOrder(int[][] matrix) {
        int startHorizontal = 0;
        int endHorizontal = matrix[0].length;
        int startVertical = 0;
        int endVertical = matrix.length;

        result = new ArrayList<>();

        while((startHorizontal < endHorizontal) && (startVertical < endVertical)) {
            traverseHorizontal(startHorizontal, endHorizontal, true, matrix, startVertical);
            startVertical++;
            traverseVertical(startVertical, endVertical, true, matrix, endHorizontal - 1);
            endHorizontal--;
            if(startVertical < endVertical) {
                traverseHorizontal(startHorizontal, endHorizontal, false, matrix, endVertical - 1);
                endVertical--;
            }
            if(startHorizontal < endHorizontal) {
                traverseVertical(startVertical, endVertical, false, matrix, startHorizontal);
                startHorizontal++;
            }
        }

        return result;
    }

    private void traverseHorizontal(int start, int end, boolean isIncreasing, int[][] matrix, int row) {
        if(start >= end) {
            return;
        }
        if(isIncreasing) {
            for(int i = start; i < end; i++) {
                result.add(matrix[row][i]);
            }
        } else {
            for(int i = end - 1; i >= start; i--) {
                result.add(matrix[row][i]);
            }
        }
    }

    private void traverseVertical(int start, int end, boolean isIncreasing, int[][] matrix, int column) {
        // System.out.println(start + ":" + end + ", " + isIncreasing + " - " + column);
        if(start >= end) {
            return;
        }
        if(isIncreasing) {
            for(int i = start; i < end; i++) {
                result.add(matrix[i][column]);
            }
        } else {
            for(int i = end - 1; i >= start; i--) {
                result.add(matrix[i][column]);
            }
        }
    }
}
