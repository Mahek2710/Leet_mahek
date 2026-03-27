import java.util.*;

class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {

        // ===== STEP 1: BUILD GRAPH =====
        // from → list of destinations
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            // Add destination to list
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }


        // ===== STEP 2: SORT DESTINATIONS =====
        // Required to get lexicographically smallest itinerary
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }


        // ===== STEP 3: DFS =====
        LinkedList<String> itinerary = new LinkedList<>();

        // Always start from "JFK"
        dfs("JFK", graph, itinerary);

        return itinerary;
    }


    // ===== DFS FUNCTION =====
    private void dfs(String airport,
                     Map<String, List<String>> graph,
                     LinkedList<String> itinerary) {

        // Get all destinations from this airport
        List<String> destinations = graph.get(airport);


        // Keep visiting until no destinations left
        while (destinations != null && !destinations.isEmpty()) {

            // Always pick smallest (because sorted)
            String next = destinations.remove(0);

            // Go deeper
            dfs(next, graph, itinerary);
        }


        // 🔥 VERY IMPORTANT:
        // Add AFTER visiting all neighbors
        // (post-order)
        itinerary.addFirst(airport);
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Given flight tickets:
[from → to]

Reconstruct itinerary:
- Start from "JFK"
- Use ALL tickets once
- Return lexicographically smallest path


================= 🧠 CORE INTUITION =================

This is an Eulerian Path problem

→ Use DFS + post-order insertion


================= 🔑 KEY IDEA =================

1. Build graph
2. Sort destinations (for smallest order)
3. DFS
4. Add node AFTER exploring neighbors


================= 🧠 EXECUTION FLOW =================

Example:

[JFK → KUL]
[JFK → NRT]
[NRT → JFK]


Graph:

JFK → [KUL, NRT]
NRT → [JFK]


STEP 1:
Start DFS("JFK")

Pick smallest → KUL


STEP 2:
DFS("KUL")

No neighbors → add KUL

Itinerary = [KUL]


STEP 3:
Back to JFK → next = NRT

DFS("NRT")


STEP 4:
NRT → JFK

DFS("JFK")


STEP 5:
No neighbors → add JFK

Itinerary = [JFK, KUL]


STEP 6:
Add NRT

Itinerary = [NRT, JFK, KUL]


STEP 7:
Add JFK

Final = [JFK, NRT, JFK, KUL]


================= ⚠️ IMPORTANT DETAIL =================

itinerary.addFirst()

→ builds result in reverse


================= ⏱ TIME & SPACE =================

Time: O(E log E) (sorting)

Space: O(E)


================= 🔥 MEMORY TRICK =================

"Use edge → DFS → add after → Reverse path"


================= 🧠 PATTERN =================

Graph + Eulerian Path (Hierholzer’s Algorithm)

Use all edges exactly once → Eulierian Path
================================================
*/