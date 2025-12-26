class TimeMap {
    private Map<String , TreeMap<Integer , String>> map;

    public TimeMap(){
        map = new HashMap<>();
    }

    public void set(String key , String value , int timestamp){
        map.computeIfAbsent(key , k -> new TreeMap<>()).put(timestamp , value);
    }

    public String get(String key , int timestamp){
        TreeMap<Integer , String> treeMap = map.get(key);

        if(treeMap == null){
            return "";
        }
        Map.Entry<Integer , String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

// set(): O(log n)
// get(): O(log n)
// TreeMap operations take logarithmic time.

// SC: O(n)
// All key–timestamp–value pairs are stored.

// 1. Maintain a HashMap where each key maps to a TreeMap.
// 2. The TreeMap stores timestamp → value pairs in sorted order.
// 3. On set(), insert the value at its timestamp for the given key.
// 4. On get(), retrieve the TreeMap for the key.
// 5. Use floorEntry() to find the latest timestamp ≤ requested time.
// 6. Return the value if found, otherwise return an empty string.

// For each key:
// time ----> value
// sorted automatically
// When you ask for a time:

// You don’t need the exact timestamp

// You need the most recent past value

// That’s exactly what floorEntry() gives.

// For each key, store values sorted by time and return the latest valid one.

// “Greatest timestamp ≤ current time” → TreeMap.floorEntry()