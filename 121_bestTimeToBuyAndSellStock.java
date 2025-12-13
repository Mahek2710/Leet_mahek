class Solution {
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            // Update minimum price seen so far (best day to buy)
            if (prices[i] < min) {
                min = prices[i];
            }

            // Update maximum profit if selling today is better
            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }
}
// TC: O(n)
// We traverse the prices array only once.

// SC: O(1)
// Only constant extra variables are used.

// 1. Assume the first day is the best day to buy initially.
// 2. Traverse prices day by day.
// 3. Keep updating the minimum price (best buy so far).
// 4. For each day, calculate profit if sold today.
// 5. Keep the maximum profit found.
// 6. Return the final maximum profit.