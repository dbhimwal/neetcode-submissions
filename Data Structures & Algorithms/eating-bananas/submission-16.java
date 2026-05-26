class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int avgHourPerPile = Math.max(h/piles.length, 1);
        int maxPossibleAnswer = max/avgHourPerPile;
        return searchAnswer(piles, h, 0, maxPossibleAnswer + 1);
    }

    public int searchAnswer(int[] piles, int h, int l, int r) {
        if((l + 1) >= r) {
            return r;
        }
        int mid = l + (r - l)/2;
        int timetaken = 0;
        for(int i = 0; i < piles.length; i++) {
            timetaken += (int) Math.ceil((double) piles[i]/mid);
        }
        // System.out.println(timetaken + ":" + mid);
        
        if (timetaken > h) {
            return searchAnswer(piles, h, mid, r);
        } else {
            return searchAnswer(piles, h, l, mid);
        }
    }
}
