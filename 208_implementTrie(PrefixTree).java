class TrieNode {

    // Each Trie node stores references to its children.
    // Since we only deal with lowercase English letters,
    // we create an array of size 26 (a–z).
    private TrieNode[] links;

    // Constant representing number of possible characters
    private final int R = 26;

    // Boolean flag that tells if a word ends at this node
    private boolean isEnd;

    // Constructor: initialize the children array
    public TrieNode() {
        links = new TrieNode[R];
    }

    // Check whether a node for the given character already exists
    // Example: for 'c' → index = 'c' - 'a' = 2
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Move to the next Trie node corresponding to character ch
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    // Create a new node for character ch and store it
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    // Mark this node as the end of a word
    public void setEnd() {
        isEnd = true;
    }

    // Check if this node represents the end of a complete word
    public boolean isEnd() {
        return isEnd;
    }
}


class Trie {

    // Root of the Trie.
    // Root does not store any character itself.
    private TrieNode root;

    // Constructor initializes the Trie with an empty root node
    public Trie() {
        root = new TrieNode();
    }


    // ================= INSERT =================
    // Insert a word into the Trie
    public void insert(String word) {

        // Start traversal from root
        TrieNode node = root;

        // Process each character of the word
        for (int i = 0; i < word.length(); i++) {

            // Extract current character
            char currentChar = word.charAt(i);

            // If path for this character doesn't exist
            // create a new node
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }

            // Move to the next node (child)
            node = node.get(currentChar);
        }

        // After inserting the last character
        // mark the node as end of the word
        node.setEnd();
    }


    // ================= PREFIX SEARCH HELPER =================
    // This helper method is used by both search() and startsWith()
    // It tries to follow the path of the given string
    public TrieNode searchPrefix(String word) {

        // Start traversal from root
        TrieNode node = root;

        // Traverse each character
        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);

            // If path exists → move forward
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } 
            else {
                // If path breaks → prefix not present
                return null;
            }
        }

        // Return the final node reached
        return node;
    }


    // ================= SEARCH FULL WORD =================
    // Returns true only if the complete word exists
    public boolean search(String word) {

        // Find node corresponding to the word
        TrieNode node = searchPrefix(word);

        // Word exists only if:
        // 1. Path exists
        // 2. Node marks end of word
        return node != null && node.isEnd();
    }


    // ================= PREFIX CHECK =================
    // Returns true if any word in the Trie starts with the prefix
    public boolean startsWith(String prefix) {

        // We only check if the prefix path exists
        TrieNode node = searchPrefix(prefix);

        return node != null;
    }
}


/*
================= LOGIC / STEPS TO REMEMBER =================

Trie (Prefix Tree) is used for efficient
prefix-based string searching.


STEP 1 — Structure of TrieNode

Each node stores:
- Array of size 26 (for 'a' to 'z')
- Boolean flag to mark end of word


STEP 2 — Insert Word

Start from root.

For each character in word:

1. Check if character node exists
2. If not → create new node
3. Move to next node

After last character → mark isEnd = true


Example:

Insert "apple"

root
  |
  a
  |
  p
  |
  p
  |
  l
  |
  e (isEnd = true)


STEP 3 — Search Word

Traverse characters one by one.

If any character link doesn't exist
→ word not present.

If traversal finishes AND isEnd = true
→ word exists.


STEP 4 — Prefix Search

Same as search but
we only check if traversal is possible.

No need to check isEnd.


================= COMPLETE EXECUTION FLOW =================

Insert "apple"

root → a → p → p → l → e


Search "apple"

Traverse same path
Check last node isEnd = true
Return true


Search "app"

Traversal possible
But isEnd = false
Return false


startsWith("app")

Traversal possible
Return true


================= TIME & SPACE =================

Insert: O(L)

Search: O(L)

StartsWith: O(L)

L = length of word


Space Complexity: O(26 × N × L)

N = number of words
L = average length


================================================
*/

// INSERT   → create nodes if missing
// SEARCH   → path exists + isEnd = true
// PREFIX   → path exists only

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */