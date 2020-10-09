import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {
    Map<Integer, List<Tweet>> tweets; // userid -> user's tweets
    Map<Integer, Set<Integer>> followees; // userid -> user's followees

    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new HashMap<>();
        followees = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        tweets.get(userId).add(0, new Tweet(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Queue<Feed> q = new PriorityQueue<>((f1, f2) -> (f2.curr.order - f1.curr.order)); // descending

        if (tweets.containsKey(userId)) {
            q.offer(new Feed(tweets.get(userId)));
        }

        if (followees.containsKey(userId)) {
            for (Integer f : followees.get(userId)) {
                if (tweets.containsKey(f)) {
                    q.offer(new Feed(tweets.get(f)));
                }
            }
        }

        List<Integer> feeds = new ArrayList<>();
        for (int i = 0; i < 10 && !q.isEmpty(); i++) {
            Feed feed = q.poll();
            feeds.add(feed.curr.id);

            if (feed.hasNext()) {
                q.offer(feed);
            }
        }

        return feeds;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!followees.containsKey(followerId)) {
            followees.put(followerId, new HashSet<>());
        }
        followees.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId)) {
            return;
        }
        followees.get(followerId).remove(followeeId);
    }

    int globalOrder = 0;

    class Tweet {
        int id;
        int order;

        Tweet(int id) {
            this.id = id;
            this.order = globalOrder++;
        }
    }

    class Feed {
        Iterator<Tweet> it;
        Tweet curr;

        Feed(List<Tweet> tweets) {
            // tweets cannot be empty
            it = tweets.iterator();
            curr = it.next();
        }

        boolean hasNext() {
            if (!it.hasNext()) {
                return false;
            }
            this.curr = it.next();
            return true;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end
