public // ===================== TRIE NODE =====================
// Each TrieNode represents one character in the Trie
class TrieNode {

    // Stores edges to next characters
    // Example: 'a' -> next node, 'b' -> next node
    HashMap<Character, TrieNode> children = new HashMap<>();

    // If a complete word ends at this node, we store it here
    // This lets us detect words during DFS without reconstructing strings
    String word = null;

    public TrieNode() {}
}


// ===================== MAIN SOLUTION =====================
class Solution {

    // Reference to the board so we can access it during DFS
    char[][] board;

    // Stores all valid words found on the board
    List<String> result = new ArrayList<>();


    public List<String> findWords(char[][] board, String[] words) {

        // STEP 1: Build a Trie containing all dictionary words
        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode node = root;

            // Insert characters of the word into Trie
            for (char ch : word.toCharArray()) {

                // If character path doesn't exist → create new node
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }

                // Move to next node
                node = node.children.get(ch);
            }

            // Store full word at the terminal node
            // This allows instant detection during DFS
            node.word = word;
        }


        // Save board reference for DFS
        this.board = board;


        // STEP 2: Start DFS from every cell in the board
        for (int r = 0; r < board.length; r++) {

            for (int c = 0; c < board[0].length; c++) {

                // Only start DFS if board letter exists in Trie root
                if (root.children.containsKey(board[r][c])) {
                    dfs(r, c, root);
                }
            }
        }

        return result;
    }


    // ===================== DFS BACKTRACKING =====================
    // Explore board starting from (row, col)
    public void dfs(int row, int col, TrieNode parent) {

        char letter = board[row][col];

        // Move to the Trie node corresponding to this letter
        TrieNode currNode = parent.children.get(letter);


        // If this Trie node contains a word → we found a valid word
        if (currNode.word != null) {

            result.add(currNode.word);

            // Set to null so we don't add duplicates
            currNode.word = null;
        }


        // Mark current board cell as visited
        // '#' ensures we don't reuse the same cell in the current path
        board[row][col] = '#';


        // Directions for exploring neighbors
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};


        // Explore all 4 neighboring cells
        for (int i = 0; i < 4; i++) {

            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            // Boundary check
            if (newRow < 0 || newRow >= board.length ||
                newCol < 0 || newCol >= board[0].length) {
                continue;
            }

            // If next board letter exists in Trie path
            // continue DFS
            if (currNode.children.containsKey(board[newRow][newCol])) {
                dfs(newRow, newCol, currNode);
            }
        }


        // BACKTRACKING STEP
        // Restore original letter so other paths can use this cell
        board[row][col] = letter;
    }
}


/*
====================== CORE IDEA ======================

We combine THREE techniques:

1️⃣ Trie (Prefix Tree)
   - Stores all dictionary words
   - Allows fast prefix checking

2️⃣ DFS
   - Explore board paths starting from each cell

3️⃣ Backtracking
   - Mark visited cells
   - Restore them after recursion


====================== WHY TRIE IS IMPORTANT ======================

Without Trie:
You would try every path for every word.

Time complexity would explode.

Trie allows early pruning:

If prefix doesn't exist → stop exploring immediately.


====================== EXECUTION FLOW ======================

Board:

o a a n
e t a e
i h k r
i f l v

Words = ["oath","eat","rain"]


1️⃣ Build Trie

root
 ├─ o
 │   └─ a
 │      └─ t
 │         └─ h
 ├─ e
 │   └─ a
 │      └─ t
 └─ r
     └─ a
        └─ i
           └─ n


2️⃣ Start DFS from each cell

If board cell matches Trie root child.


3️⃣ Explore neighbors recursively

Example path:

o → a → t → h

Word found → add "oath"


====================== TIME COMPLEXITY ======================

O(M × N × 4^L)

M,N = board size
L = max word length

Trie pruning greatly reduces search space.


====================== SPACE COMPLEXITY ======================

Trie storage: O(W × L)

W = number of words
L = average word length

Recursion stack: O(L)

==============================================================
*/ {
    
}
