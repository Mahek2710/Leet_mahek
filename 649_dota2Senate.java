class Solution {
    public String predictPartyVictory(String senate) {

        int n = senate.length();

        // Queues to store indices of Radiant and Dire senators
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();

        // Fill queues based on initial senate order
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        // Process bans until one party is eliminated
        while (!r.isEmpty() && !d.isEmpty()) {

            int ri = r.poll(); // next Radiant senator
            int di = d.poll(); // next Dire senator

            // The senator with smaller index acts first
            if (ri < di) {
                // Radiant bans Dire, Radiant comes back in next round
                r.offer(ri + n);
            } else {
                // Dire bans Radiant, Dire comes back in next round
                d.offer(di + n);
            }
        }

        // Party with remaining senators wins
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}

// TC: O(n)
// Each senator is processed and re-added at most once.

// SC: O(n)
// Two queues storing senator indices.


/*
CODE WORKFLOW:

1. Store positions of Radiant (R) and Dire (D) senators in separate queues.
2. Each queue represents the order in which senators will act.
3. Repeatedly compare the front of both queues:
   - The senator with the smaller index acts first.
4. The acting senator bans the opponent:
   - The winner is re-added to their queue with index + n
     (meaning they will act again in the next round).
5. The banned senator is removed permanently.
6. Continue until one queue becomes empty.
7. The party with remaining senators wins.
*/
