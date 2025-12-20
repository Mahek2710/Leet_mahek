class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> lines = new ArrayList<>();
        int index = 0;

        // Process words line by line
        while (index < words.length) {

            int count = words[index].length(); // length of current line
            int last = index + 1;

            // Try to fit as many words as possible in the current line
            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth) {
                    break;
                }
                count += 1 + words[last].length();
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);

            int gaps = last - index - 1; // number of spaces between words

            // Case 1: Last line OR only one word in the line → left justified
            if (last == words.length || gaps == 0) {

                // Add one space between words
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }

                // Pad remaining spaces at the end
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }

            } 
            // Case 2: Fully justify the line
            else {

                int spaces = (maxWidth - count) / gaps;      // minimum spaces per gap
                int extraSpaces = (maxWidth - count) % gaps; // extra spaces to distribute

                for (int i = index + 1; i < last; i++) {

                    // Add evenly distributed spaces
                    for (int s = spaces; s > 0; s--) {
                        builder.append(" ");
                    }

                    // Add extra space to left gaps if needed
                    if (extraSpaces > 0) {
                        builder.append(" ");
                        extraSpaces--;
                    }

                    // One mandatory space before the next word
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }

            // Add the justified line to result
            lines.add(builder.toString());

            // Move to next line
            index = last;
        }

        return lines;
    }
}

// TC: O(n)
// Each word is processed once.

// SC: O(n)
// Space used to store the output lines.


// 1. Take as many words as possible to fit in one line.
// 2. Check how many gaps (spaces) exist between words.
// 3. If it's the last line or only one word → left justify.
// 4. Otherwise, distribute spaces evenly across gaps.
// 5. Give extra spaces to the leftmost gaps.
// 6. Build the line and add it to the result.
