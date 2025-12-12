class Solution {
    public int firstMissingPositive(int[] nums) {

        int contains = 0;
        int n = nums.length;

        // --------------------------------------------------------
        // STEP 1 — Check if the number 1 exists in the array.
        //
        // Why?
        //   The smallest missing positive must be in the range [1..n+1].
        //   If 1 is NOT present, then the answer is immediately 1.
        // --------------------------------------------------------
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) {
            return 1;   // no 1 → first missing positive is 1
        }

        // --------------------------------------------------------
        // STEP 2 — Normalize the array.
        //
        // Replace any value that:
        //   • is ≤ 0 (not positive)
        //   • is > n (too large to matter)
        //
        // with the number 1.
        //
        // Why?
        //   The only values that could possibly be the first missing
        //   positive are in the range [1..n].
        //
        // Using 1 is safe because we already know 1 exists in the array.
        // --------------------------------------------------------
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // --------------------------------------------------------
        // STEP 3 — Mark which numbers exist by using the array index
        //          as a hash.
        //
        // For a value 'a' in nums:
        //   • If a == n, mark nums[0] as negative to represent "n exists".
        //   • Otherwise, mark nums[a] as negative to represent "a exists".
        //
        // We take the absolute value because nums[] may already be negative.
        //
        // Why negative?
        //   A negative number at an index indicates that the index value
        //   appeared somewhere in the array.
        // --------------------------------------------------------
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]); // presence of n
            } else {
                nums[a] = -Math.abs(nums[a]); // presence of a
            }
        }

        // --------------------------------------------------------
        // STEP 4 — Find the first positive value in indices 1..n-1.
        //
        // If nums[i] is positive, it means we never marked index i,
        // so the number i is missing from the array.
        // --------------------------------------------------------
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        // --------------------------------------------------------
        // STEP 5 — If nums[0] is still positive, then 'n' is missing.
        //
        // This works because we used nums[0] as the marker for 'n'.
        // --------------------------------------------------------
        if (nums[0] > 0) {
            return n;
        }

        // --------------------------------------------------------
        // STEP 6 — If none of the previous checks found a missing
        //          number, then all values 1..n are present.
        //
        // Therefore, the smallest missing positive is n + 1.
        // --------------------------------------------------------
        return n + 1;
    }
}


// TC: O(n)
// We scan the array a constant number of times; each loop is O(n).

// SC: O(1)
// We modify the input array in-place and use only constant extra variables.


// Steps (simple and interview-friendly):
// 1. Check if 1 exists. If not → return 1 immediately.
// 2. Normalize the array: replace values <=0 or >n with 1.
// 3. For each value a = abs(nums[i]):
//    - if a == n -> mark nums[0] negative to indicate n exists
//    - else -> mark nums[a] negative to indicate a exists
// 4. Scan indices 1..n-1: first index i with nums[i] > 0 means i is missing -> return i.
// 5. If nums[0] > 0 -> n is missing -> return n.
// 6. If none above -> all 1..n exist -> return n+1.
