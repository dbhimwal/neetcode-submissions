class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target, 0, matrix.length);
        System.out.println(row);
        return findColumn(matrix[row], target, 0, matrix[row].length);
    }
    public int findRow(int[][] matrix, int target, int top, int below) {
        if(below == top + 1) {
            return top;
        }
        if(below < top + 1) {
            return top - 1;
        }
        int mid = top + (below - top)/2;
        if(target < matrix[mid][0]) {
            return findRow(matrix, target, top, mid);
        }  else if(target > matrix[mid][0]) {
            return findRow(matrix, target, mid, below);
        } else {
            return mid;
        }
    }
    public boolean findColumn(int[] matrix, int target, int left, int right) {
        if(right <= left) {
            return false;
        }
        int mid = left + (right - left)/2;
        if(target < matrix[mid]) {
            return findColumn(matrix, target, left, mid);
        }  else if(target > matrix[mid]) {
            return findColumn(matrix, target, mid + 1, right);
        } else {
            return true;
        }
    }
}
