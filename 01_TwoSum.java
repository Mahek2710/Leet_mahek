class Solution {

    public int[] twoSum(int[] nums, int target) {

        // Map will store: number → index
        // WHY?
        // So we can quickly check if complement exists in O(1)
        Map<Integer, Integer> map = new HashMap<>();


        // Traverse the array once (no nested loop → O(n))
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];          // current number at index i
            int diff = target - current;   // value needed to reach target


            // ===== CHECK =====
            // Check if required complement already appeared BEFORE
            // WHY?
            // Because we store previous elements in map
            if (map.containsKey(diff)) {

                // If found → we already saw the needed number
                // map.get(diff) → index of that number
                // i → current index
                return new int[]{map.get(diff), i};
            }


            // ===== STORE =====
            // Store current number AFTER checking
            // WHY?
            // To avoid using same element twice
            map.put(current, i);
        }


        // As per problem, solution always exists
        return null;
    }
}


/*
================= 🧠 PROBLEM THINKING =================

Brute Force:
- Check every pair → O(n^2) ❌ (too slow)

Optimized Thinking:
- Instead of checking pairs,
  ask: "Mujhe target banane ke liye kya chahiye?"

- For each number:
  → Find complement = target - current
  → Check if it already exists

- Convert problem into FAST LOOKUP → use HashMap


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Create HashMap → stores (number → index)
   → keeps track of elements we've already seen

2. Traverse array once

3. For each element:
   a) Calculate diff = target - current
   b) Check if diff exists in map
        → YES → return indices
        → NO → store current element

4. Continue until solution found

KEY IDEA:
- Map stores PAST elements
- Current element tries to match with PAST


================= 🔄 EXECUTION FLOW =================

Example:
nums = [2, 7, 11, 15]
target = 9


Step 1:
i = 0
current = 2
diff = 7

map = {}
→ 7 not found

STORE → {2:0}


Step 2:
i = 1
current = 7
diff = 2

map = {2:0}
→ 2 found ✅

RETURN → [0,1]


================= ⏱ TIME COMPLEXITY =================

O(n)

- Single loop
- HashMap lookup → O(1)


================= 📦 SPACE COMPLEXITY =================

O(n)

- In worst case, all elements stored in map


================= 🎯 MEMORY LINE =================

"Check complement in map, then store current."

====================================================
*/

/*
================= 🧠 THINKING =================

For every number:
→ Find what number is needed to make target

Instead of checking all pairs (O(n²)),
use HashMap for fast lookup.


================= 🧠 EXECUTION FLOW =================

Example:

nums = [2, 7, 11, 15]
target = 9


STEP 1:
i = 0 → num = 2
need = 7

map = {}
→ not found → store 2

map = {2:0}


STEP 2:
i = 1 → num = 7
need = 2

map = {2:0}
→ found ✅

return [0,1]


================= ⏱ TIME COMPLEXITY =================

O(n)

- Single pass through array
- HashMap lookup is O(1)


================= 📦 SPACE COMPLEXITY =================

O(n)

- In worst case, we store all elements in map


================================================
*/