### 🔹 08/12/25

1. **LeetCode 1 — Two Sum**  
   - Used HashMap for efficient lookup  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

2. **LeetCode 217 — Contains Duplicate**  
   - Used HashSet to detect duplicates  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

3. **LeetCode 219 — Contains Duplicate II**  
   - Used Sliding Window with HashSet  
   - Time Complexity: O(n)  
   - Space Complexity: O(k)

### 🔹 09/12/25

1. **LeetCode 242 — Valid Anagram**  
   - Used character frequency array  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

2. **LeetCode 49 — Group Anagrams**  
   - Used HashMap with frequency pattern as key  
   - Time Complexity: O(n * k)  
   - Space Complexity: O(n)

3. **LeetCode 238 — Product of Array Except Self**  
   - Used prefix and postfix multiplication  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

### 🔹 11/12/25

1. **LeetCode 347 — Top K Frequent Elements**  
   - Used frequency map + min-heap (keep heap size = k)  
   - Time Complexity: O(n log k)  
   - Space Complexity: O(n)

2. **LeetCode 13 — Roman to Integer**  
   - Used a fixed map for single & special pairs, scan with lookahead for 2-char pairs  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

3. **LeetCode 953 — Verifying an Alien Dictionary**  
   - Built char → rank map, compare each adjacent word letter-by-letter, handle prefix case  
   - Time Complexity: O(n * m) — n = #words, m = average word length  
   - Space Complexity: O(1)
  
### 🔹 12/12/25

1. **LeetCode 128 — Longest Consecutive Sequence**  
   - Used HashSet and start-of-sequence scanning  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

2. **LeetCode 41 — First Missing Positive**  
   - Used in-place index marking (normalize values, mark presence by negation)  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)
  
### 🔹 13/12/25 - Started with Sliding Window problems

1. **LeetCode 121 — Best Time to Buy and Sell Stock**  
   - Tracked minimum price so far and maximum profit  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

2. **LeetCode 567 — Permutation in String**  
   - Used sliding window with character frequency arrays  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

3. **LeetCode 424 — Longest Repeating Character Replacement**  
   - Used sliding window with max-frequency tracking  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

### 🔹 14/12/25

1. **LeetCode 3 — Longest Substring Without Repeating Characters**  
   - Used sliding window with HashSet to maintain unique characters  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

2. **LeetCode 239 — Sliding Window Maximum**  
   - Used deque to maintain decreasing order of elements’ indices  
   - Time Complexity: O(n)  
   - Space Complexity: O(k)

3. **LeetCode 76 — Minimum Window Substring**  
   - Used sliding window with frequency maps and two pointers  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

### 🔹 15/12/25

1. **LeetCode 125 — Valid Palindrome**  
   - Used two pointers, skipped non-alphanumeric characters, compared case-insensitively  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

2. **LeetCode 167 — Two Sum II (Input Array Is Sorted)**  
   - Used two-pointer technique on sorted array  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

3. **LeetCode 15 — 3Sum**  
   - Sorted array, fixed one element and applied two-pointer approach, skipped duplicates  
   - Time Complexity: O(n²)  
   - Space Complexity: O(1)
     
### 🔹 16/12/25

1. **LeetCode 11 — Container With Most Water**  
   - Used two pointers, starting from widest container and moving the shorter wall inward  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

2. **LeetCode 42 — Trapping Rain Water**  
   - Used two-pointer approach with leftMax and rightMax to calculate trapped water  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

3. **LeetCode 26 — Remove Duplicates from Sorted Array**  
   - Used two pointers (read & write) to overwrite duplicates in-place  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

### 🔹 17/12/25

1. **LeetCode 31 — Next Permutation**  
   - Found break point from the right, swapped with next greater element, and reversed the suffix  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

2. **LeetCode 412 — Fizz Buzz**  
   - Simple iteration with conditional checks for multiples of 3 and 5  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

3. **LeetCode 14 — Longest Common Prefix**  
   - Started with first string as prefix and gradually shortened it to match all strings  
   - Time Complexity: O(n × m)  
   - Space Complexity: O(1)

### 🔹 19/12/25

1. **LeetCode 271 — Encode and Decode Strings**  
   - Used a unique delimiter character to encode strings and split using the same delimiter to decode  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

2. **LeetCode 647 — Palindromic Substrings**  
   - Used expand-around-center technique to count both odd and even length palindromes  
   - Time Complexity: O(n²)  
   - Space Complexity: O(1)


