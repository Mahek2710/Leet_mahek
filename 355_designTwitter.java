public class Twitter {

    // Global timestamp → increases for every tweet
    private static int timeStamp = 0;

    // Map: userId → User object
    private Map<Integer, User> userMap;

    /** Initialize Twitter */
    public Twitter() {
        userMap = new HashMap<>();
    }

    // ================= USER CLASS =================
    private class User {

        int id;

        // Stores all users this user follows
        // (including themselves)
        Set<Integer> followed;

        // Head of tweet linked list (most recent tweet)
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();

            // User should follow themselves to see own tweets
            follow(id);

            tweetHead = null;
        }

        public void follow(int followeeId) {
            followed.add(followeeId);
        }

        public void unfollow(int followeeId) {
            // Cannot unfollow yourself
            if (followeeId != this.id) {
                followed.remove(followeeId);
            }
        }

        /** Post a new tweet → add at head (latest first) */
        public void post(int tweetId) {
            Tweet newTweet = new Tweet(tweetId);

            // Insert at head (like linked list push)
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    // ================= TWEET CLASS =================
    private class Tweet {

        int id;
        int time;     // timestamp for ordering
        Tweet next;   // next older tweet

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++; // increasing order
            this.next = null;
        }
    }

    // ================= POST TWEET =================
    public void postTweet(int userId, int tweetId) {

        // Create user if not present
        userMap.putIfAbsent(userId, new User(userId));

        // Add tweet to user's tweet list
        userMap.get(userId).post(tweetId);
    }

    // ================= GET NEWS FEED =================
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> newsFeed = new LinkedList<>();

        // If user does not exist → empty feed
        if (!userMap.containsKey(userId)) {
            return newsFeed;
        }

        // Get all followed users
        Set<Integer> followedUsers = userMap.get(userId).followed;

        // Max heap → most recent tweet first
        PriorityQueue<Tweet> tweetHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add the most recent tweet of each followed user
        for (int followedUserId : followedUsers) {

            Tweet tweet = userMap.get(followedUserId).tweetHead;

            if (tweet != null) {
                tweetHeap.add(tweet);
            }
        }

        // Extract top 10 most recent tweets
        int count = 0;

        while (!tweetHeap.isEmpty() && count < 10) {

            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id);
            count++;

            // Move to next older tweet of same user
            if (tweet.next != null) {
                tweetHeap.add(tweet.next);
            }
        }

        return newsFeed;
    }

    // ================= FOLLOW =================
    public void follow(int followerId, int followeeId) {

        // Create users if not present
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        userMap.get(followerId).follow(followeeId);
    }

    // ================= UNFOLLOW =================
    public void unfollow(int followerId, int followeeId) {

        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

// postTweet → O(1)
//
// getNewsFeed → O(F log F + 10 log F)
// F = number of followed users
// Heap size is at most F
//
// follow / unfollow → O(1)
//
// SC → O(U + T)
// U = users, T = tweets


// 1. Each user has:
//    - A set of followed users
//    - A linked list of their tweets (latest at head)
//
// 2. Posting a tweet → insert at head of linked list.
//
// 3. News Feed:
//    - Take all followed users
//    - Put their latest tweet into a max heap (by timestamp)
//    - Pop most recent tweet
//    - Add its next older tweet into heap
//    - Repeat until we get 10 tweets
//
// 4. Follow → add followee to set
// 5. Unfollow → remove from set (except self)
