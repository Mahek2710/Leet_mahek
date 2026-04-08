class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // ===== STEP 1: BUILD CHARACTER RANK MAP =====
        // We convert the alien alphabet into a lookup table:
        // Example: order = "hlabc..."
        // Then: h → 0, l → 1, a → 2 ...
        //
        // WHY?
        // Because we cannot compare characters directly (like 'a' < 'b')
        // We must compare using alien ranking instead.

        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }


        // ===== STEP 2: COMPARE EACH ADJACENT PAIR =====
        // Just like dictionary:
        // If every adjacent pair is sorted → whole array is sorted
        //
        // Example:
        // ["cat", "dog", "zebra"]
        // We only check:
        // (cat, dog) and (dog, zebra)

        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];       // current word
            String w2 = words[i + 1];   // next word


            // ===== STEP 3: COMPARE CHARACTERS =====
            // We compare letter by letter (like dictionary comparison)
            //
            // As soon as we find a DIFFERENT character,
            // we decide the order and STOP further comparison

            for (int j = 0; j < w1.length(); j++) {

                // ===== EDGE CASE: PREFIX PROBLEM =====
                // If w2 finishes but w1 still has characters:
                //
                // Example:
                // "apple"
                // "app"
                //
                // "app" should come first, but here it's second → WRONG
                //
                // So if j crosses w2 length → invalid

                if (j >= w2.length()) {
                    return false;
                }

                char c1 = w1.charAt(j); // char from first word
                char c2 = w2.charAt(j); // char from second word


                // ===== CASE 1: CHARACTERS DIFFER =====
                // This is where actual comparison happens
                //
                // Example:
                // "hello" vs "leetcode"
                // compare 'h' vs 'l'

                if (c1 != c2) {

                    // Get alien ranking of both characters
                    int pos1 = orderMap.get(c1);
                    int pos2 = orderMap.get(c2);

                    // If first word's character comes AFTER second word's
                    // → order is wrong
                    if (pos1 > pos2) {
                        return false;
                    }

                    // If correct order:
                    // we STOP checking this pair immediately
                    // because dictionary comparison only depends
                    // on first different character
                    break;
                }

                // ===== CASE 2: CHARACTERS SAME =====
                // If equal → move to next character
            }
        }

        // ===== FINAL RESULT =====
        // If no violations found → array is sorted
        return true;
    }
}


/*
================= 🧠 PROBLEM THINKING =================

We are given:
- Words sorted in "alien language"
- Custom order of characters

Goal:
- Verify if words are sorted according to that order

👉 Similar to normal dictionary, but with custom ranking


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Create orderMap:
   → character → rank

2. Compare each adjacent pair:
   (words[i], words[i+1])

3. For each pair:
   a) Compare characters one by one

   b) If characters differ:
        → check their rank
        → if wrong → return false
        → else → stop checking this pair

   c) If all same but length differs:
        → shorter word should come first


================= 🔄 EXECUTION FLOW =================

Example:
words = ["hello","leetcode"]
order = "hlabcdefgijkmnopqrstuvwxyz"


Map:
h→0, l→1, a→2, b→3, ...


Compare:
"hello" vs "leetcode"

j=0:
h vs l

pos(h)=0, pos(l)=1
→ correct order ✅

Stop checking → move next pair


----------------------

Example 2 (IMPORTANT EDGE CASE):

words = ["apple","app"]

Compare:
"apple" vs "app"

j=0 → a==a  
j=1 → p==p  
j=2 → p==p  

Now:
w2 ends but w1 still has characters

→ INVALID ❌


================= ⏱ TIME COMPLEXITY =================

O(n * m)

- n = number of words
- m = average length of word


================= 📦 SPACE COMPLEXITY =================

O(1)

- orderMap size fixed (26 letters)


================= 🎯 MEMORY LINE =================

"Compare adjacent words using custom rank + handle prefix case."

====================================================
*/