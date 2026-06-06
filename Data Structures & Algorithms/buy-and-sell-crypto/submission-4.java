class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int price : prices){
            if(price < buy){
                buy = price;
                sell = price;
            } else {
                sell = Math.max(sell, price);
            }
            profit = Math.max(profit, sell-buy);
        }

        return profit;
    }
}
