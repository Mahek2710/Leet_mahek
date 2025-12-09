class Solution {
    public boolean isAnagram(String s, String t) {
        
        //check length (length hi alag hai toh aage kya faayda)
        if(s.length() != t.length()){
            return false;
        }

        //create array to calculate the frequency
        int [] charCounts = new int[26] ; // assuming only small case

        //count++ for each char in 's'
        //count-- for each char in 't'

        for(int i = 0 ; i < s.length() ; i++){  
            //s.length() == t.length() is already checked, so same loop covers both strings   safely         

            charCounts[s.charAt(i) - 'a']++; 
            charCounts[t.charAt(i) - 'a']--;

            //char - 'a' gives index 0–25 for lowercase letters (e.g. 'c' - 'a' = 2)
        }

        //check if all counts are zero
        for(int count : charCounts){
            if(count != 0)
            return false;
        }

        return true ; //all counts = 0 hence s is an anagram of t or viceversa
    }
}


// TC: O(n) - One pass through both strings.
// SC: O(1) - Fixed size array of 26 characters. woh badhega nahi fixed rehta hai 26 hi isliye 1.


// 1. Check if both strings have the same length.
// 2. Create a frequency array of size 26.
// 3. Increment count for each character in s.
// 4. Decrement count for each character in t.
// 5. If any value in the array is not zero(meaning ek mein kam zyada hai chars), return false.
// 6. If all values are zero, return true (valid anagram).
