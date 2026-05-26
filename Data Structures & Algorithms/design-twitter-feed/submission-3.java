class Twitter {
    class Tweet {
        int createTime;
        int postId;

        public Tweet(int time, int id) {
            createTime = time;
            postId = id;
        }
    }
    Map<Integer, List<Tweet>> posts;
    Map<Integer, Set<Integer>> followers;
    int time;

    public Twitter() {
        posts = new HashMap<>();
        followers = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = posts.getOrDefault(userId, new ArrayList<>());
        tweets.add(new Tweet(time++ ,tweetId));
        posts.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> friends = followers.get(userId);
        List<Integer> feeds = new ArrayList<>();
        PriorityQueue<Tweet> news = new PriorityQueue<>((a, b) -> (b.createTime - a.createTime));

        for (Tweet userPost : posts.getOrDefault(userId, new ArrayList<>())) {
            news.add(userPost);
        }

        if(friends != null) {
            for(Integer friend : friends) {
                List<Tweet> userPosts = posts.get(friend);
                for (Tweet userPost : userPosts) {
                    news.add(userPost);
                }
            }
        }
        int i = 0;
        while(!news.isEmpty() && i < 10) {
            feeds.add(news.poll().postId);
            i++;
        }
        return feeds;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) { return; }
        Set<Integer> friends = followers.getOrDefault(followerId, new HashSet<>());
        friends.add(followeeId);
        followers.put(followerId, friends);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> friends = followers.get(followerId);
        if(friends != null) {
            friends.remove(followeeId);
        }
    }
}
