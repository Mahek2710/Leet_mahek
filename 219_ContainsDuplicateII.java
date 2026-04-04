class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k){

        // HashSet acts as a SLIDING WINDOW of size at most k
        // It will always contain elements from index range: [i-k ... i-1]
        Set<Integer> set = new HashSet<>();


        // Traverse the array
        for(int i = 0; i < nums.length; i++){

            // ===== CHECK =====
            // If current number already exists in window → duplicate within k distance
            if(set.contains(nums[i])){
                return true;
            }

            // ===== STORE =====
            // Add current element into window
            set.add(nums[i]);

            // ===== MAINTAIN WINDOW =====
            // If window size exceeds k, remove the element which is OUTSIDE range
            // That element is at index (i - k)

            // WHY i - k?
            // Because we only want elements whose index difference ≤ k
            // So we remove elements that are more than k distance away

            if(set.size() > k){

                // nums[i - k] is the element which is now too far from current index i
                // (distance becomes > k), so we remove it
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}


/*
================= 🧠 PROBLEM THINKING =================

We need to check:
|i - j| ≤ k AND nums[i] == nums[j]

So:
- Only elements within distance k matter
- Ignore everything beyond k

👉 Maintain a window of size k


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Use HashSet → acts like sliding window

2. Traverse array

3. For each index i:
   - Check if nums[i] already exists in set
   - Add nums[i] to set
   - If window exceeds size k:
        → remove nums[i - k]

WHY remove nums[i - k]?
- Because it's now more than k distance away from current index i


================= 🔄 EXECUTION FLOW =================

Example:
nums = [1,2,3,1], k = 2


Step 1:
i = 0 → num = 1
set = {}
ADD → {1}


Step 2:
i = 1 → num = 2
set = {1}
ADD → {1,2}


Step 3:
i = 2 → num = 3
set = {1,2}
ADD → {1,2,3}

Now size > k (3 > 2)
REMOVE nums[i-k] = nums[2-2] = nums[0] = 1

New set → {2,3}

👉 Meaning: we removed elements too far (>k distance)


Step 4:
i = 3 → num = 1
set = {2,3}

CHECK → 1 not present ❌

ADD → {2,3,1}

Again size > k → remove nums[3-2] = nums[1] = 2
New set → {3,1}


END → No valid duplicate within distance k


================= ⏱ TIME COMPLEXITY =================

O(n)
- One traversal
- HashSet operations → O(1)


================= 📦 SPACE COMPLEXITY =================

O(k)
- At most k elements stored


================= 🎯 MEMORY LINE =================

"Keep only last k elements → remove nums[i-k] when window grows."

====================================================
*/