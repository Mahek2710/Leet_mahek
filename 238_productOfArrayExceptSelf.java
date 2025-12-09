class Solution{
    public int[] productExceptSelf(int[] nums){

        int[] result = new int[nums.length];

        Arrays.fill(result,1);

        int pre = 1 , post = 1;

        for(int i = 0 ; i < nums.length ; i++){
            result[i] = pre;
            pre = nums[i]*pre;
        }
        for(int i = nums.length-1 ; i >= 0 ; i--){
            result[i] = result[i] * post;
            post = post*nums[i];
        }

        return result;
    }
}



// TC: O(n) -> The array is traversed twice, once from left and once from right.

// SC: O(1) -> No extra space is used apart from the output array which is asked in qs ✅ Space Complexity is O(1) because we only use two extra variables (pre and post).The result array is not counted since it is the required output, not extra helper space..


// 1. Create a result array and fill it with 1.
// 2. Use a variable `pre` to keep track of product from the left.
// 3. Traverse from left to right and store left-side product in result.
// 4. Use a variable `post` to keep track of product from the right.
// 5. Traverse from right to left and multiply right-side product into result.
// 6. Return the final result array.

