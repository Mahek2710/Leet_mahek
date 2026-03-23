public class Solution extends Relation {

    private int numOfPeople;


    // ===== MAIN FUNCTION =====
    public int findCelebrity(int n) {

        numOfPeople = n;

        int candidate = 0; // assume person 0 is celebrity


        // ===== STEP 1: FIND POTENTIAL CANDIDATE =====
        // Eliminate non-celebrities
        for (int i = 1; i < n; i++) {

            // If candidate knows i → candidate can't be celebrity
            // So update candidate
            if (knows(candidate, i)) {
                candidate = i;
            }
        }


        // ===== STEP 2: VERIFY CANDIDATE =====
        if (isCelebrity(candidate)) {
            return candidate;
        }

        return -1;
    }


    // ===== CHECK IF PERSON IS CELEBRITY =====
    public boolean isCelebrity(int i) {

        for (int j = 0; j < numOfPeople; j++) {

            if (i == j) continue;


            // Condition for celebrity:
            // 1. Celebrity should NOT know anyone
            // 2. Everyone should know celebrity

            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }

        return true;
    }
}


/*
================= 🧾 PROBLEM BRIEF =================

There are n people.

A celebrity is someone:
1. Everyone knows them
2. They know no one

Find the celebrity index or return -1


================= 🧠 CORE INTUITION =================

We don't check everyone directly ❌

We ELIMINATE people smartly ✅


================= 🔑 KEY IDEA =================

STEP 1 → Find candidate
STEP 2 → Verify candidate


================= 🧠 EXECUTION FLOW =================

Example:

0 1 2 3

Check:
0 knows 1 → 0 can't be celeb → candidate = 1  
1 knows 2 → 1 can't be celeb → candidate = 2  
2 doesn't know 3 → 2 still possible  


Final candidate = 2


STEP 2:
Check if 2:
- knows nobody
- everyone knows 2

If yes → return 2


================= ⚠️ IMPORTANT DETAIL =================

Bug you had:

if (knows(i,j) || !knows(i,j)) ❌

Correct:

if (knows(i,j) || !knows(j,i)) ✅


================= ⏱ TIME & SPACE =================

Time Complexity: O(n)

- 1 pass → find candidate
- 1 pass → verify


Space Complexity: O(1)


================= 🔥 MEMORY TRICK =================

"If A knows B → A can't be celeb"

OR

"Final candidate → must be verified"


================= 🧠 PATTERN =================

Greedy Elimination + Verification

Similar idea:
- Find majority element
- Candidate elimination problems


================================================
*/