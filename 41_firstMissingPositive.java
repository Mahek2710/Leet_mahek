class Solution {
    public int firstMissingPositive(int[] nums) {

        int contains = 0;
        int n = nums.length;

        // ===== STEP 1: CHECK IF 1 EXISTS =====
        // WHY?
        // → Smallest missing positive must be in [1..n+1]
        // → If 1 is missing, answer is directly 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) {
            return 1;
        }

        // ===== STEP 2: NORMALIZATION =====
        // Replace invalid values (≤0 or >n) with 1
        // WHY?
        // → Only numbers in range [1..n] matter
        // → Others can be ignored safely
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // ===== STEP 3: MARK PRESENCE USING INDEX =====
        // Use index as hash to mark presence
        // Negative value → number exists
        for (int i = 0; i < nums.length; i++) {

            int a = Math.abs(nums[i]); // get actual value

            if (a == n) {
                // Use index 0 to represent presence of n
                nums[0] = -Math.abs(nums[0]);
            } else {
                // Mark index 'a' negative → means 'a' exists
                nums[a] = -Math.abs(nums[a]);
            }
        }

        // ===== STEP 4: FIND FIRST MISSING =====
        // Check indices 1..n-1
        // If positive → that index number is missing
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        // ===== STEP 5: CHECK FOR n =====
        // If nums[0] is positive → n is missing
        if (nums[0] > 0) {
            return n;
        }

        // ===== STEP 6: ALL PRESENT =====
        // If all 1..n exist → answer is n+1
        return n + 1;
    }
}


/*
================= 🧠 PROBLEM THINKING =================

Goal:
- Find smallest missing positive integer

Brute Force:
- Sort → O(n log n) ❌
- Use extra space → O(n) ❌

Constraint:
👉 Must solve in O(n) time and O(1) space

Key Insight:
👉 Answer will ALWAYS lie in range [1..n+1]


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Check if 1 exists
   → If not → return 1

2. Normalize array
   → Remove useless values (≤0 or >n)

3. Use array as HASH:
   → Mark presence using index

4. Find first positive index
   → That index is missing number

5. Handle special cases:
   → nums[0] for 'n'
   → else return n+1


================= 🔑 CORE IDEA (MOST IMPORTANT) =================

👉 Use array index as hash map

Index = number  
Value = sign (positive/negative)

Negative → number exists  
Positive → number missing


================= 🔄 EXECUTION FLOW =================

Example:
nums = [3,4,-1,1]


Step 1:
1 exists ✅ → continue

Step 2 (normalize):
[3,4,1,1]

Step 3 (marking):

i=0 → 3 → mark index 3 negative
→ [3,4,1,-1]

i=1 → 4 → mark index 0 negative (represents 4)
→ [-3,4,1,-1]

i=2 → 1 → mark index 1 negative
→ [-3,-4,1,-1]

i=3 → 1 → already marked


Step 4 (scan):
index 1 → negative  
index 2 → POSITIVE ✅

→ missing = 2


================= ⏱ TIME COMPLEXITY =================

O(n)

- Multiple passes but all linear


================= 📦 SPACE COMPLEXITY =================

O(1)

- In-place modification
- No extra data structures

You’re already thinking in the right direction — now let’s turn this into a **clean, interview-level intuition** that sticks in your head without needing to reread all comments.

---

# 🧠 The Real Way to Think About This Problem

### 🎯 Goal:

Find the **smallest missing positive number** in an unsorted array.

---

## 🚨 Step 0: The Most Important Observation

> “The answer will ALWAYS be between **1 and n+1**”

Why?

* If array size = `n`
* Maximum useful positives you can have = `1…n`
* If all exist → answer = `n+1`

👉 This single idea drives the entire solution.

---

## 🧩 Step 1: Handle the easiest case first

> “If 1 is missing → answer is 1”

Because:

* 1 is the **smallest positive**
* If it's not there, nothing else matters

---

## 🧹 Step 2: Clean the garbage values

We only care about numbers in:

```
[1 ... n]
```

So we convert:

* negatives ❌
* zero ❌
* numbers > n ❌

👉 into `1` (safe filler)

Why `1`?

* Because we already confirmed `1 exists`
* So replacing won't affect answer

---

## 🧠 Step 3: Use the array as a hash map

This is the **core trick** 🔥

We use:

```
Index = number
Value = sign (presence marker)
```

### Idea:

* If number `x` exists → mark index `x` as negative

Example:

```
nums = [3,4,1,1]

Meaning:
3 exists → make nums[3] negative
```

---

## ⚠️ Special Trick: Handling number `n`

Index range:

```
0 to n-1
```

But we need to mark number `n`

👉 So we use:

```
index 0 → represents number n
```

---

## 🔍 Step 4: Find the missing number

Now scan:

* Index `i` from `1 → n-1`
* If value is **positive** → number `i` is missing

---

## 🎯 Step 5: Final checks

* If index `0` is positive → `n` is missing
* Otherwise → everything exists → answer = `n + 1`

---

# 🔥 Full Intuition in One Flow

Think like this:

> “I will convert the array into a presence tracker using signs”

1. Ensure `1` exists
2. Ignore useless values
3. Use indices to mark presence
4. First positive index = missing number

---

# 🧪 Visual Example (Super Clear)

```
nums = [3,4,-1,1]
n = 4
```

### After cleaning:

```
[3,4,1,1]
```

### Marking:

* 3 → mark index 3
* 4 → mark index 0
* 1 → mark index 1

```
[-3, -4, 1, -1]
```

### Scan:

* index 1 → negative
* index 2 → POSITIVE ✅

👉 Missing = **2**

---

# 🧠 Memory Trick (Short + Powerful)

> “Index ko number samajh, aur sign ko presence.”

---

# 💡 Why This Problem Feels Hard

Because it combines:

* Math observation (range: 1 to n+1)
* In-place hashing
* Index manipulation
* Edge case (n mapped to 0)

---

# 🚀 Final Mental Model

If you remember just this, you're good:

> “We don't search for the answer… we FORCE the array to reveal it.”

---

If you want next level clarity, I can:

* Show **why this is O(1) space (important for interviews)**
* Or compare this with **cyclic sort approach** (another popular solution)

================= 🎯 MEMORY LINE =================

"Index ko hash bana, sign se presence mark kar."

====================================================
*/

// Steps (simple and interview-friendly):
// 1. Check if 1 exists. If not → return 1 immediately.
// 2. Normalize the array: replace values <=0 or >n with 1.
// 3. For each value a = abs(nums[i]):
//    - if a == n -> mark nums[0] negative to indicate n exists
//    - else -> mark nums[a] negative to indicate a exists
// 4. Scan indices 1..n-1: first index i with nums[i] > 0 means i is missing -> return i.
// 5. If nums[0] > 0 -> n is missing -> return n.
// 6. If none above -> all 1..n exist -> return n+1.
