class Solution{
    public boolean containsDuplicate(int[] nums){

        // Create a HashSet to store elements
        // WHY HashSet?
        // → It allows O(1) lookup to check duplicates quickly
        HashSet<Integer> seenNumbers = new HashSet<>();


        // Traverse each element in array (single pass → O(n))
        for(int num : nums){

            // ===== CHECK =====
            // If number already exists in set → duplicate found
            if(seenNumbers.contains(num)){
                return true; // duplicate exists
            }

            // ===== STORE =====
            // If not found, store number for future checks
            seenNumbers.add(num);
        }

        // If loop completes → no duplicates
        return false;
    }
}


/*
================= 🧠 PROBLEM THINKING =================

Brute Force:
- Compare every pair → O(n^2) ❌

Optimized Thinking:
- Instead of comparing pairs,
  track elements we’ve already seen

- If we ever see the same element again → duplicate exists

- Convert problem into LOOKUP problem → use HashSet


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Create HashSet → stores seen elements

2. Traverse array

3. For each element:
   a) Check if it already exists in set
        → YES → duplicate → return true
        → NO → add it to set

4. If traversal completes → no duplicates → return false

KEY IDEA:
- Set stores PAST elements
- Current element checks against PAST


================= 🔄 EXECUTION FLOW =================

Example:
nums = [1,2,3,1]


Step 1:
num = 1
set = {}
→ not found

ADD → {1}


Step 2:
num = 2
set = {1}
→ not found

ADD → {1,2}


Step 3:
num = 3
set = {1,2}
→ not found

ADD → {1,2,3}


Step 4:
num = 1
set = {1,2,3}
→ FOUND ✅

RETURN → true


================= ⏱ TIME COMPLEXITY =================

O(n)

- Single traversal
- HashSet lookup → O(1) average


================= 📦 SPACE COMPLEXITY =================

O(n)

- In worst case, all elements stored in set


================= 🎯 MEMORY LINE =================

"If element already in set → duplicate found."

====================================================
*/