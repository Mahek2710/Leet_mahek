class Solution{
    public int[] twoSum(int[] nums, int target){

        Map<Integer,Integer> map = new HashMap<>();

        //Traverse the array
        for(int i = 0 ; i < nums.length; i++){
            int diff = target - nums[i];

            //If the difference is in the map , return the indices
            if(map.containsKey(diff)){
                return new int[]{map.get(diff) , i};
            }

            //Otherwise,store the number and its index
            map.put(nums[i],i);
        }

        return null; //when no soln found. but would never happen as problem statement has constraints ki exactly 1 ans hoga hi hoga
    }
}



// TC: O(n) - One pass through the array, O(1) lookups in HashMap.
// SC: O(n) - At worst, storing all elements in HashMap.
 


// 1. Check if target - num is in map.
// 2. If yes, return indices.
// 3. Else, store num and its index.


