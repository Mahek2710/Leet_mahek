class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Graph: course → list of prerequisites it depends on
        // Example: [1,0] means 1 depends on 0 → edge: 1 → 0
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();


        // ================= BUILD GRAPH =================
        for (int[] pre : prerequisites) {

            int course = pre[0];   // course to take
            int prereq = pre[1];   // dependency

            // If course already exists → just add dependency
            if (courseGraph.containsKey(course)) {
                courseGraph.get(course).add(prereq);
            } 
            // Else create new list
            else {
                List<Integer> list = new LinkedList<>();
                list.add(prereq);
                courseGraph.put(course, list);
            }
        }


        // This set tracks nodes in CURRENT DFS path
        // IMPORTANT:
        // Not global visited → only tracks recursion stack
        HashSet<Integer> pathVisited = new HashSet<>();


        // Try starting DFS from every course
        for (int currentCourse = 0; currentCourse < numCourses; currentCourse++) {

            // If any DFS finds a cycle → cannot finish
            if (!dfs(currentCourse, pathVisited, courseGraph)) {
                return false;
            }
        }

        return true;
    }


    // ================= DFS FUNCTION =================
    public boolean dfs(int course,
                       HashSet<Integer> pathVisited,
                       HashMap<Integer, List<Integer>> courseGraph) {

        // 🔴 CYCLE DETECTION:
        // If course already exists in CURRENT path → cycle
        // Example: 0 → 1 → 2 → 0
        if (pathVisited.contains(course)) {
            return false;
        }


        // If course has NO prerequisites → nothing to check
        // means it's already safe
        if (courseGraph.get(course) == null) {
            return true;
        }


        // Add course to current recursion path
        pathVisited.add(course);


        // Explore all its prerequisites
        for (int pre : courseGraph.get(course)) {

            // If any dependency leads to cycle → fail
            if (!dfs(pre, pathVisited, courseGraph)) {
                return false;
            }
        }


        // Backtracking step:
        // Remove course from current path
        // (we are done exploring this branch)
        pathVisited.remove(course);


        // 🔥 OPTIMIZATION:
        // Mark this course as "already checked & safe"
        // So next time we skip it
        courseGraph.put(course, null);

        return true;
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Given:
- numCourses (0 to n-1)
- prerequisites (u, v → u depends on v)

Goal:
Return true if you can complete ALL courses.


================= 🧠 CORE INTUITION =================

This is a CYCLE DETECTION problem in a directed graph.

If there is a cycle:
→ You can NEVER finish all courses


================= 🔑 KEY IDEA =================

Use DFS + recursion stack:

- If we revisit a node in SAME DFS path → cycle


================= 🧠 EXECUTION FLOW =================

Example:

0 → 1
1 → 2
2 → 0   (cycle)


STEP 1:
Start DFS(0)

STEP 2:
0 → 1 → 2

STEP 3:
2 → tries to go to 0 again

0 already in current path → cycle detected

RETURN false


================= ⚠️ IMPORTANT DETAIL =================

pathVisited = recursion stack

NOT global visited

We:
add → while going deeper
remove → while backtracking


================= 🔥 OPTIMIZATION =================

courseGraph.put(course, null);

→ Marks course as already processed
→ Avoids rechecking same node again


================= ⏱ TIME & SPACE =================

Time Complexity: O(V + E)

- Each node and edge visited once


Space Complexity: O(V)

- Recursion stack + pathVisited


================= 🔥 MEMORY TRICK =================

"Same node in same DFS path = cycle"

OR

"Back-edge = cycle"


================= 🧠 PATTERN =================

Graph + DFS + Cycle Detection (Directed Graph)

Used in:
- Course Schedule
- Detect Cycle in Directed Graph
- Topological Sort


================================================
*/