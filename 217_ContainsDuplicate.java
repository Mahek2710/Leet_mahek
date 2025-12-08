class Solution{
    public boolean containsDuplicate(int[] nums){
        //Create a HashSet to store elements from the array
        HashSet<Integer> seenNumbers = new HashSet<>();

        //Iterate through each element in the array
        for(int num : nums){
            //Check if the element is already in the HashSet
            if(seenNumbers.contains(num)){
                return true; //Duplicate found
            }

            //Add element to the HashSet
            seenNumbers.add(num);
        }

        return false; //No duplicates found
    }
}



// TC: O(n) - One pass through the array with O(1) average lookup in HashSet.
// SC: O(n) - At worst, storing all elements in the HashSet.


// 1. Create a HashSet to store seen elements.
// 2. Traverse the array and check if the number already exists in the set.
// 3. If yes, return true (duplicate found).
// 4. Otherwise, add the number to the set.
// 5. If loop finishes, return false.
