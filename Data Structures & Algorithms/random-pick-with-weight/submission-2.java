class Solution {
    private int total_weight;
    private int[] weightedIndex;
    
    public Solution(int[] w) {
        total_weight = 0;
        weightedIndex = new int[w.length];

        for(int i = 0; i < w.length; i++) {
            weightedIndex[i] = total_weight;
            total_weight += w[i];
        }
    }

    public int pickIndex() {
        double weightPosition = Math.random() * total_weight;
        return searchIndex(weightPosition, 0, weightedIndex.length);
    }

    private int searchIndex(double weightPosition, int start, int end) {
        System.out.println(weightPosition + ": " + start + "-" + end);
        if(start >= end-1) {
            return start;
        }
        int mid = (start+end)/2;
        if(weightedIndex[mid] == weightPosition) {
            return mid;
        }
        if(weightedIndex[mid] > weightPosition) {
            return searchIndex(weightPosition, start, mid);
        } else {
            return searchIndex(weightPosition, mid, end);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */