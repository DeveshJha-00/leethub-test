class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit=0, min=prices[0];

        // for (int i=1; i<n; i++){
        //     int currProfit = prices[i] - min;
        //     maxProfit = Math.max(maxProfit, currProfit);
        //     min = Math.min(min, prices[i]);
        // }

        for (int price:prices){ 
            min = Math.min(min, price);
            if ((price-min) > maxProfit){
                maxProfit = price-min;
            }
        }
        return maxProfit;
    }
}