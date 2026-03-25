class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] edge : times){
            graph.computeIfAbsent(edge[0],x -> new ArrayList<>()).add(new int[]{edge[1],edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k,0});

        int[] distances = new int[n+1];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[k] = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if(currentDist > distance[currentNode]){
                continue;
            }

            if(graph.containsKey(currentNode)){
                for(int[] neighbor : graph.get(currentNode)){
                    int nextNode = neighbor[0];
                    int nextDist = currentDist + neighbor[1];
                    if(nextDist < distances[nextNode]){
                        distances[nextNode] = nextDist;
                        pq.offer(new int[]{nextNode,nextDist});
                    }
                }
            }
        }
    }

    int maxDist = Arrays.stream(distances).skip(1).max().getAsInt();
    return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
}


/*
================= 🧾 PROBLEM BRIEF =================

Find time for signal from node k to reach all nodes


================= 🧠 CORE INTUITION =================

Shortest path in weighted graph

→ Use Dijkstra


================= 🔑 KEY IDEA =================

Use min-heap:
Always process smallest distance first


================= 🧠 EXECUTION FLOW =================

Example:

times = [
  [1,2,1],
  [1,3,4],
  [2,3,1]
]
k = 1


Graph:

1 → 2 (1)
1 → 3 (4)
2 → 3 (1)


STEP 1:
Start from node 1

Priority Queue:
[(1,0)]


STEP 2:
Pop (1,0)

Visit neighbors:
→ 2 with distance 1
→ 3 with distance 4

PQ becomes:
[(2,1), (3,4)]


STEP 3:
Pop (2,1)  ← smallest distance

Visit neighbors:
→ 3 with distance = 1 + 1 = 2

Now update:
distance[3] = 2 (better than 4)

PQ becomes:
[(3,2), (3,4)]


STEP 4:
Pop (3,2)

No further neighbors


STEP 5:
Pop (3,4)

Skip because:
4 > 2 (outdated path)


FINAL DISTANCES:

1 → 0  
2 → 1  
3 → 2  


Answer = max = 2


================= ⚠️ IMPORTANT DETAIL =================

Skip outdated paths:

if (currentDist > distances[node]) continue;


================= ⏱ TIME & SPACE =================

Time: O(E log V)

Space: O(V + E)


================= 🔥 MEMORY TRICK =================

"Smallest distance first → priority queue"

OR

"Outdated path → skip"


================= 🧠 PATTERN =================

Graph + Dijkstra

================================================
*/