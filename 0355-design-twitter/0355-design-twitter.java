class Twitter {
    private Map<Integer, List<Integer>> userTweetsMap;
    private Map<Integer, Set<Integer>> userFollowsMap;
    private Map<Integer, Integer> tweetIdToTimestampMap;
    private static int timestamp;

    public Twitter() {
        userTweetsMap = new HashMap<>();
        userFollowsMap = new HashMap<>();
        tweetIdToTimestampMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweetsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweetId);
        tweetIdToTimestampMap.put(tweetId, ++timestamp);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = userFollowsMap.getOrDefault(userId, new HashSet<>());
        following.add(userId);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((tid1, tid2) -> 
                                    tweetIdToTimestampMap.get(tid2) - tweetIdToTimestampMap.get(tid1));
        for (int user : following) {
            List<Integer> tweets = userTweetsMap.get(user);
            if (tweets != null) {
                int tweetCount = tweets.size();
                for (int i=tweetCount-1; i>=0; i--) {
                    minHeap.offer(tweets.get(i));
                }
            }
        }
        List<Integer> feed = new ArrayList<>();
        int feedSize = 10;
        while (!minHeap.isEmpty() && feed.size() < feedSize) {
            feed.add(minHeap.poll());
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowsMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollowsMap.containsKey(followerId)) {
            userFollowsMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */