public class Codec {

    public String encode(List<String> strs) {

        // Special marker to represent an empty list
        if (strs.size() == 0) {
            return Character.toString((char) 258);
        }

        // Delimiter character that won't appear in normal strings
        String separator = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();

        // Join all strings using the separator
        for (String s : strs) {
            sb.append(s);
            sb.append(separator);
        }

        // Remove the last extra separator
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public List<String> decode(String s) {

        // If encoded string is the empty-list marker
        if (s.equals(Character.toString((char) 258))) {
            return new ArrayList<>();
        }

        // Same separator used during encoding
        String separator = Character.toString((char) 257);

        // Split the string back into the original list
        return Arrays.asList(s.split(separator, -1));
    }
}

// TC: O(n)
// Total number of characters processed during encode + decode.

// SC: O(n)
// Space used for encoded string and decoded list.


// 1. Use a rare delimiter character to separate strings.
// 2. Encode by joining all strings with this delimiter.
// 3. Use a special marker to represent an empty list.
// 4. Decode by splitting the encoded string using the same delimiter.
// 5. Return the reconstructed list of strings.
