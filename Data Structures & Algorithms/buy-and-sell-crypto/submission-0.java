class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int maxProf = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            minPrice = Math.min(minPrice, prices[i]);

            int currProf = prices[i] - minPrice;
            maxProf = Math.max(maxProf, currProf);
        }

        return maxProf;
    }
}
