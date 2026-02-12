class Solution {
    public int[][] highFive(int[][] items) {

        // Step 0:
        // We need to calculate each student's TOP 5 average.
        // So we will:
        // 1. Group scores by student ID.
        // 2. Use a max heap for each student to easily get highest scores.
        // 3. Extract top 5 scores.
        // 4. Compute average.
        // 5. Return results sorted by ID.

        // TreeMap is used so that student IDs remain sorted automatically.
        // Key = student ID
        // Value = max heap of scores
        Map<Integer, PriorityQueue<Integer>> scores = new TreeMap<>();


        // Step 1: Group all scores by student ID
        for (int[] item : items) {

            int id = item[0];     // student ID
            int score = item[1];  // student's score

            // If this student is not yet in the map,
            // create a max heap for them.
            // (a, b) -> b - a makes it a MAX heap.
            if (!scores.containsKey(id)) {
                scores.put(id, new PriorityQueue<>((a, b) -> b - a));
            }

            // Add this score into that student's heap
            scores.get(id).add(score);
        }


        // Step 2: For each student, compute top 5 average
        List<int[]> ans = new ArrayList<>();

        // Loop through each student in sorted order (TreeMap ensures this)
        for (int id : scores.keySet()) {

            int sum = 0;

            // Step 3: Extract top 5 highest scores
            // Since it's a max heap, poll() gives largest each time
            for (int i = 0; i < 5; i++) {
                sum += scores.get(id).poll();
            }

            // Step 4: Add [id, average] into result list
            ans.add(new int[]{id, sum / 5});  // integer division
        }


        // Step 5: Convert List<int[]> into int[][]
        int[][] ansArray = new int[ans.size()][2];

        return ans.toArray(ansArray);
    }
}


// TC: O(n log n)
// - Each score is inserted into a heap (log n in worst case).
// - For each student, we remove top 5 scores (constant work).
// - TreeMap keeps keys sorted (log n insertion).

// SC: O(n)
// - We store all scores inside heaps.
// - In worst case, all scores are stored.

// 1. Use a TreeMap so student IDs remain sorted automatically.
// 2. Group scores by student ID.
// 3. For each student, store scores in a max heap.
// 4. Extract the top 5 largest scores using poll().
// 5. Compute average using integer division.
// 6. Store [id, average] in result.
// 7. Convert list to 2D array and return.
