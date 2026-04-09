class Solution {
    public int maxProfit(int[] prices) {

        // 🟢 Step 1: Assume first day is the best day to buy
        int min = prices[0];  

        // 🟢 Step 2: No profit initially
        int profit = 0;

        // 🟢 Step 3: Traverse each day
        for (int i = 0; i < prices.length; i++) {

            // 🔽 UPDATE BUY PRICE
            // If today's price is cheaper than what we've seen,
            // update min → better day to buy
            min = Math.min(min, prices[i]);

            // 🔼 TRY SELLING TODAY
            // Profit if we sell today using BEST buy so far
            int todayProfit = prices[i] - min;

            // 🏆 UPDATE MAX PROFIT
            // Keep the best profit seen so far
            profit = Math.max(profit, todayProfit);
        }

        // 🎯 Final answer: best profit possible
        return profit;
    }
}

/*
================= 🧠 PROBLEM THINKING =================

Goal:
- Buy at lowest price
- Sell at highest price AFTER buying

Constraint:
👉 Buy must happen BEFORE sell


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Initialize:
   - min → first day's price (assume best buy)
   - profit → 0 (no profit yet)

2. Traverse each day:
   - Update min → best buying price so far
   - Assume selling today
   - Compute today's profit

3. Update max profit


================= 🔑 CORE IDEA (MOST IMPORTANT) =================

👉 At each day:
   "If I sell today, what's my profit using the best buy so far?"

👉 So:
   todayProfit = prices[i] - min

   Best buy so far + sell today = profit

================= CODE MAPPING =================


min = Math.min(min, prices[i]);        // best buy so far
int todayProfit = prices[i] - min;     // sell today
profit = Math.max(profit, todayProfit);// best result



================= 🔄 EXECUTION FLOW =================

Example:
prices = [7,1,5,3,6,4]


Initial:
min = 7
profit = 0


Day 0 (7):
min = min(7,7) = 7
todayProfit = 7 - 7 = 0
profit = max(0,0) = 0


Day 1 (1):
min = min(7,1) = 1 ✅ better buy
todayProfit = 1 - 1 = 0
profit = 0


Day 2 (5):
min = 1
todayProfit = 5 - 1 = 4 ✅
profit = max(0,4) = 4


Day 3 (3):
min = 1
todayProfit = 3 - 1 = 2
profit = max(4,2) = 4


Day 4 (6):
min = 1
todayProfit = 6 - 1 = 5 ✅
profit = max(4,5) = 5


Day 5 (4):
min = 1
todayProfit = 4 - 1 = 3
profit = max(5,3) = 5


Final Answer:
5


================= ⏱ TIME COMPLEXITY =================

O(n)
- Single loop


================= 📦 SPACE COMPLEXITY =================

O(1)
- Only min, profit, todayProfit used


================= 🎯 MEMORY LINE =================

"Update min → compute today's profit → update max"

====================================================
*/