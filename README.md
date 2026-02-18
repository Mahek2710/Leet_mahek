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

### 🔹 20/12/25

1. **LeetCode 5 — Longest Palindromic Substring**  
   - Used expand-around-center technique to handle both odd and even length palindromes  
   - Time Complexity: O(n²)  
   - Space Complexity: O(1)

2. **LeetCode 68 — Text Justification**  
   - Greedily packed words per line and handled left vs full justification using space distribution  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

3. **LeetCode 704 — Binary Search**  
   - Applied classic binary search on a sorted array using left and right pointers  
   - Time Complexity: O(log n)  
   - Space Complexity: O(1)

4. **LeetCode 34 — Find First and Last Position of Element in Sorted Array**  
   - Used binary search twice to find the leftmost and rightmost occurrence of the target  
   - Time Complexity: O(log n)  
   - Space Complexity: O(1)

### 🔹 21/12/25

1. **LeetCode 88 — Merge Sorted Array**  
   - Merged two sorted arrays in-place by filling from the end using three pointers  
   - Time Complexity: O(m + n)  
   - Space Complexity: O(1)

### 🔹 22/12/25

1. **LeetCode 75 — Sort Colors (Dutch National Flag Problem)**  
   - Used three pointers to separate RED (0), WHITE (1), and BLUE (2) in-place  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

### 🔹 24/12/25

1. **LeetCode 169 — Majority Element**  
   - Used HashMap to count frequencies and selected the element with maximum count  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

2. **LeetCode 74 — Search a 2D Matrix**  
   - Treated the 2D matrix as a flattened sorted array and applied binary search  
   - Time Complexity: O(log(m × n))  
   - Space Complexity: O(1)

3. **LeetCode 153 — Find Minimum in Rotated Sorted Array**  
   - Used binary search to discard sorted halves and track the minimum element  
   - Time Complexity: O(log n)  
   - Space Complexity: O(1)

4. **LeetCode 33 — Search in Rotated Sorted Array**  
   - Identified the sorted half at each step and performed binary search accordingly  
   - Time Complexity: O(log n)  
   - Space Complexity: O(1)

### 🔹 26/12/25

1. **LeetCode 148 — Sort List**  
   - Applied merge sort on a singly linked list using slow/fast pointer splitting and merging  
   - Time Complexity: O(n log n)  
   - Space Complexity: O(log n)

2. **LeetCode 179 — Largest Number**  
   - Converted numbers to strings and sorted them using a custom comparator based on concatenation order  
   - Time Complexity: O(n log n)  
   - Space Complexity: O(n)

3. **LeetCode 875 — Koko Eating Bananas**  
   - Used binary search on the answer space to find the minimum valid eating speed  
   - Time Complexity: O(n log m)  
   - Space Complexity: O(1)

4. **LeetCode 981 — Time Based Key-Value Store**  
   - Used HashMap with TreeMap to store values by timestamp and retrieve the latest valid entry  
   - Time Complexity: O(log n) per operation  
   - Space Complexity: O(n)

### 🔹 29/12/25

1. **LeetCode 4 — Median of Two Sorted Arrays**  
   - Used binary search on partitions to find the median efficiently  
   - Time Complexity: O(log(min(m, n)))  
   - Space Complexity: O(1)

### 🔹 30/12/25

1. **LeetCode 876 — Middle of the Linked List**  
   - Used slow and fast pointers to find the middle in one pass  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

2. **LeetCode 206 — Reverse Linked List**  
   - Iteratively reversed pointers using prev, curr, and temp  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

3. **LeetCode 141 — Linked List Cycle**  
   - Applied Floyd’s cycle detection using slow and fast pointers  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

### 🔹 31/12/25

1. **LeetCode 21 — Merge Two Sorted Lists**  
   - Merged two sorted linked lists by iteratively attaching the smaller node  
   - Time Complexity: O(n + m)  
   - Space Complexity: O(1)

2. **LeetCode 19 — Remove Nth Node From End of List**  
   - Used two-pointer technique with a fixed gap to remove the target node in one pass  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

3. **LeetCode 2 — Add Two Numbers**  
   - Simulated digit-by-digit addition with carry using a new linked list  
   - Time Complexity: O(max(m, n))  
   - Space Complexity: O(max(m, n))

### 🔹 02/01/26

1. **LeetCode 143 — Reorder List**  
   - Found the middle of the list, reversed the second half, and merged both halves alternately  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

2. **LeetCode 287 — Find the Duplicate Number**  
   - Treated the array as a linked list and used Floyd’s cycle detection  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)

3. **LeetCode 138 — Copy List with Random Pointer**  
   - Used recursion with HashMap to create deep copies of nodes  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

4. **LeetCode 23 — Merge k Sorted Lists**  
   - Collected all node values using a min-heap and rebuilt a sorted list  
   - Time Complexity: O(N log N)  
   - Space Complexity: O(N)

### 🔹 08/01/25

1. **LeetCode 25 — Reverse Nodes in k-Group**  
   - Reversed the linked list in groups of size `k` using pointer manipulation  
   - Time Complexity: O(n)  
   - Space Complexity: O(1)
  
### 🔹 10/01/25

1. **LeetCode 114 — Flatten Binary Tree to Linked List**  
   - Used recursion to flatten left and right subtrees and rewired pointers in preorder  
   - Time Complexity: O(n)  
   - Space Complexity: O(h)
     
  
   ### 🔸 STACKS

2. **LeetCode 20 — Valid Parentheses**  
   - Used a stack and HashMap to validate matching brackets  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

3. **LeetCode 155 — Min Stack**  
   - Implemented a stack that supports push, pop, top, and getMin in O(1)  
   - Used an auxiliary stack to track the minimum element at each level  
   - Time Complexity: O(1) per operation  
   - Space Complexity: O(n)

4. **LeetCode 716 — Max Stack**  
   - Implemented a stack supporting push, pop, top, peekMax, and popMax  
   - Used an auxiliary stack to track the maximum element at each level  
   - Time Complexity:  
     - push, pop, top, peekMax → O(1)  
     - popMax → O(n)  
   - Space Complexity: O(n)
  

### 🔹 17/01/26

1. **LeetCode 739 — Daily Temperatures**  
   - Used a monotonic decreasing stack to find the next warmer day for each index  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

2. **LeetCode 853 — Car Fleet**  
   - Calculated time to reach target and grouped cars into fleets based on arrival time  
   - Time Complexity: O(n log n)  
   - Space Complexity: O(n)

3. **LeetCode 150 — Evaluate Reverse Polish Notation**  
   - Used a stack to evaluate expressions by applying operators to the last two operands  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)

### 🔹 23/01/26

1. **LeetCode 32 — Longest Valid Parentheses**  
   - Used a stack of indices with a base index to track valid substring lengths  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)
  
### 🔹 25/01/26
1. **LeetCode 84 — Largest Rectangle in Histogram**  
   - Used a monotonic increasing stack to compute maximum rectangle area  
   - Calculated width dynamically when popping heights  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)
     
### 🔹 26/01/26 

1. **LeetCode 232 — Implement Queue using Stacks**  
   - Used two stacks (`inStack`, `outStack`) with lazy transfer  
   - Achieved amortized O(1) for push, pop, and peek  
   - Time Complexity: Amortized O(1)  
   - Space Complexity: O(n)


### 🔹 27/01/26


1. **LeetCode 225 — Implement Stack using Queues**  
   - Used two queues and reordered elements during push  
   - Made pop and top operations O(1)  
   - Time Complexity: push O(n), pop/top O(1)  
   - Space Complexity: O(n)

2. **LeetCode 622 — Design Circular Queue**  
   - Implemented using a fixed-size array with head pointer and size tracking  
   - Used modulo arithmetic to achieve circular behavior  
   - Time Complexity: O(1) for all operations  
   - Space Complexity: O(k)

### 🔹 05/02/26

1. **LeetCode 752 — Open the Lock**  
   - Modeled lock combinations as graph nodes and used BFS to find the minimum moves  
   - Generated neighbors by rotating each wheel forward and backward  
   - Skipped deadends and already visited states  
   - Time Complexity: O(10⁴)  
   - Space Complexity: O(10⁴)

2. **LeetCode 649 — Dota2 Senate**  
   - Simulated the voting process using two queues to track turn order  
   - Used index comparison to decide bans and reinsert winners for next rounds  
   - Time Complexity: O(n)  
   - Space Complexity: O(n)



### 🔹 10/02/26

1. **LeetCode 1046 — Last Stone Weight**  
   - Used a max-heap to repeatedly smash the two heaviest stones  
   - Reinserted the remaining weight after each smash  
   - Time Complexity: O(n log n)  
   - Space Complexity: O(n)

2. **LeetCode 215 — Kth Largest Element in an Array**  
   - Maintained a min-heap of size `k` to track the k largest elements  
   - The heap top gives the kth largest value  
   - Time Complexity: O(n log k)  
   - Space Complexity: O(k)

3. **LeetCode 973 — K Closest Points to Origin**  
   - Used a max-heap to keep only the k closest points to the origin  
   - Discarded farther points dynamically based on squared distance  
   - Time Complexity: O(n log k)  
   - Space Complexity: O(k)



### 🔹 12/02/26

1. **LeetCode 1086 — High Five**  
   - Grouped scores by student ID using TreeMap  
   - Used a max-heap per student to extract top 5 scores  
   - Computed integer average of highest 5 scores  
   - Time Complexity: O(n log n)  
   - Space Complexity: O(n)

2. **LeetCode 703 — Kth Largest Element in a Stream**  
   - Maintained a min-heap of size k  
   - Heap always stores k largest elements seen so far  
   - Heap top represents kth largest element  
   - Time Complexity: O(n log k) (constructor), O(log k) per add  
   - Space Complexity: O(k)

3. **LeetCode 621 — Task Scheduler**  
   - Counted task frequencies using HashMap  
   - Used max-heap to always schedule highest frequency task first  
   - Processed tasks in cycles of (n + 1) to respect cooldown  
   - Time Complexity: O(n log k)  
   - Space Complexity: O(k)

### 🔹 12/02/26

1. **LeetCode 759 — Employee Free Time**  
   - Pushed all intervals into a min-heap sorted by start time  
   - Merged overlapping intervals to track working periods  
   - Identified gaps between merged intervals as common free time  
   - Time Complexity: O(n log n)  
   - Space Complexity: O(n)

### 🔹 16/02/26
1. **LeetCode 295 — Find Median from Data Stream**  
   - Used two heaps (max-heap for smaller half, min-heap for larger half)  
   - Balanced heaps to maintain size property  
   - Median from top of heaps (odd → max-heap top, even → average of both)  
   - Time Complexity: O(log n) per add, O(1) findMedian  
   - Space Complexity: O(n)
  
### 🔹 17/02/26

1. **LeetCode 355 — Design Twitter**  
   - Designed User and Tweet classes with linked list for tweets  
   - Each user follows themselves automatically  
   - Used max-heap to merge tweets from followed users by timestamp  
   - Retrieved top 10 most recent tweets for news feed  
   - Time Complexity:  
     - postTweet → O(1)  
     - follow/unfollow → O(1)  
     - getNewsFeed → O(F log F) (F = number of followed users)  
   - Space Complexity: O(U + T) (users + tweets)
  
### 🔹 19/02/26

1. **LeetCode 104 — Maximum Depth of Binary Tree**  
   - Used DFS recursion to compute tree height  
   - Returned 1 + max(leftDepth, rightDepth)  
   - Time Complexity: O(n)  
   - Space Complexity: O(h)

2. **LeetCode 100 — Same Tree**  
   - Recursively compared both trees  
   - Checked null cases, node values, and subtrees  
   - Time Complexity: O(n)  
   - Space Complexity: O(h)

3. **LeetCode 101 — Symmetric Tree**  
   - Checked mirror structure using recursion  
   - Compared left subtree of one side with right subtree of the other  
   - Time Complexity: O(n)  
   - Space Complexity: O(h)

4. **LeetCode 226 — Invert Binary Tree**  
   - Recursively swapped left and right children  
   - Post-order style inversion  
   - Time Complexity: O(n)  
   - Space Complexity: O(h)










