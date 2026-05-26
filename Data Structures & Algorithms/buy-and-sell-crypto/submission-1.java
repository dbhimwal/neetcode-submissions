class Solution {
    public int maxProfit(int[] prices) {
        int[] maxPriceInFuture = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            if(i == 0) {
                maxPriceInFuture[prices.length - 1 - i] = prices[prices.length - 1 - i];
                // System.out.println(maxPriceInFuture[prices.length - 1 - i]);
            } else {
                maxPriceInFuture[prices.length - 1 - i] = Math.max(prices[prices.length - 1 - i], maxPriceInFuture[prices.length - i]);
                // System.out.println(maxPriceInFuture[prices.length - 1 - i]);
            }
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxPriceInFuture[i] - prices[i]);
        }

        return maxProfit;
    }
}
