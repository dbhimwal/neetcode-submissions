class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        boolean increasing = true;
        int row = 0;
        for(int i = 0; i < s.length(); i++) {
            sb[row].append(s.charAt(i));
            if(increasing) {
                if(row == numRows - 1) {
                    increasing = false;
                    row--;
                } else {
                    row++;
                }
            } else {
                if(row == 0) {
                    increasing = true;
                    row++;
                } else {
                    row--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            result.append(sb[i].toString());
        }
        return result.toString();
    }
}