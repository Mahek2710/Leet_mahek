class Solution {
    public int longestConsecutive(int[] nums) {

        // If array is empty → no sequence
        if (nums.length == 0) {
            return 0;
        }

        // ===== HASHSET CREATION =====
        // Store all numbers for O(1) lookup
        // WHY?
        // → To quickly check if next/previous number exists
        HashSet<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSub = 1; // stores max sequence length


        // ===== MAIN LOGIC =====
        // Iterate through unique elements only
        for (int num : numSet) {

            // ===== START CHECK =====
            // If (num - 1) exists → this is NOT start of sequence
            // WHY?
            // → Because sequence already started earlier
            if (numSet.contains(num - 1)) {
                continue; // skip non-start elements
            }

            // ===== START OF SEQUENCE =====
            int currentNum = num;
            int currentSub = 1;

            // Expand sequence forward
            while (numSet.contains(currentNum + 1)) {
                currentNum++;   // move to next number
                currentSub++;   // increase length
            }

            // Update maximum length
            longestSub = Math.max(longestSub, currentSub);
        }

        return longestSub;
    }
}


/*
================= 🧠 PROBLEM THINKING =================

Goal:
- Find longest sequence of consecutive numbers

Brute Force:
- Sort array → O(n log n) ❌

Optimized Thinking:
- Order doesn't matter → use HashSet
- Check existence of next numbers in O(1)


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Put all elements in HashSet

2. Traverse set

3. For each number:
   a) Check if it's start of sequence
        → (num - 1) NOT present

   b) If start:
        → keep checking (num + 1), (num + 2), ...

   c) Count length

4. Track max length


================= 🔑 KEY IDEA (MOST IMPORTANT) =================

👉 ONLY start from BEGINNING of sequence

WHY?

Example:
nums = [1,2,3,4]

Without check:
- Start from 1 → 4 steps
- Start from 2 → 3 steps
- Start from 3 → 2 steps
- Start from 4 → 1 step

→ O(n^2) ❌

With check:
- Start ONLY from 1
→ O(n) ✅


================= 🔄 EXECUTION FLOW =================

Example:
nums = [100,4,200,1,3,2]


Set:
{100,4,200,1,3,2}


Check:

100 → (99 not present) → start
→ sequence: 100 → length = 1

4 → (3 present) → skip

200 → (199 not present) → start
→ sequence: 200 → length = 1

1 → (0 not present) → start
→ sequence: 1 → 2 → 3 → 4
→ length = 4 ✅


Final Answer:
4


================= ⏱ TIME COMPLEXITY =================

O(n)

- Each number processed once
- While loop overall still O(n)


================= 📦 SPACE COMPLEXITY =================

O(n)

- HashSet stores all elements


================= 🎯 MEMORY LINE =================

"Start only where (num - 1) doesn't exist."

====================================================
*/