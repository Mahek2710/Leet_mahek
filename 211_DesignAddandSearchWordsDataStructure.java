class TrieNode {

    // Stores all possible next characters from this node
    // Key = character, Value = next TrieNode
    Map<Character, TrieNode> children = new HashMap<>();

    // Marks if a COMPLETE word ends at this node
    // Important: prefix ≠ full word
    boolean word = false;

    public TrieNode() {}
}


class WordDictionary {

    // Root of Trie (starting point)
    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();
    }
    

    // ===================== INSERT =====================
    public void addWord(String word) {

        TrieNode node = trie;

        // Build Trie path character by character
        for (char ch : word.toCharArray()) {

            // If path doesn't exist → create new node
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }

            // Move forward in Trie
            node = node.children.get(ch);
        }

        // Mark end of word
        // Without this, we can't differentiate "app" vs "apple"
        node.word = true;        
    }
    

    // ===================== SEARCH CORE =====================
    public boolean searchInNode(String word, TrieNode node) {

        // Traverse each character of input word
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);


            // CASE 1: Character NOT present in Trie
            if (!node.children.containsKey(ch)) {

                // If it's a wildcard '.', we must try ALL possibilities
                if (ch == '.') {

                    // Branch out → try every child
                    for (char x : node.children.keySet()) {

                        TrieNode child = node.children.get(x);

                        // Recursively check remaining string
                        // If ANY path works → return true
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }

                    // No matching path found
                    return false;
                } 
                else {
                    // Normal character missing → word doesn't exist
                    return false;
                }
            } 
            else {
                // CASE 2: Character exists → move forward normally
                node = node.children.get(ch);
            }
        }

        // After processing all characters:
        // Check if this node marks END of a valid word
        return node.word;
    }


    // ===================== SEARCH API =====================
    public boolean search(String word) {

        // Start searching from root
        return searchInNode(word, trie);
    }
}
/*
================= COMPLETE EXECUTION FLOW =================

Words added:
"bad", "dad", "mad"


Search: ".ad"

STEP 1:
Start at root

Character = '.'
→ wildcard → try ALL children:
   try 'b', 'd', 'm'


STEP 2:
Pick 'b'

Now remaining word = "ad"

Traverse:
a → exists
d → exists

Reached end → node.word = true
→ return true


STEP 3:
Since one path worked → stop further search

Final Answer = true


----------------------------------------------------------

Search: "b.."

STEP 1:
b → move to node 'b'

STEP 2:
'.' → try all children of 'b'

STEP 3:
Again '.' → try all children

STEP 4:
Check if any path ends with word = true

→ If yes → return true


================= TIME & SPACE =================

Add Word:
Time Complexity: O(L)
Space Complexity: O(L) per word

----------------------------------------------------------

Search:

Worst Case Time Complexity: O(26^L)

Reason:
- Every '.' creates branching
- Each level can explore up to 26 children

----------------------------------------------------------

Important Note ⚠️:

This implementation uses:

word.substring(i + 1)

This creates a new string each time,
so actual cost can be closer to:

O(L × 26^L)

----------------------------------------------------------

Space Complexity:

O(N × L)

N = number of words
L = average word length

+ recursion stack up to O(L)

================================================
*/

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */