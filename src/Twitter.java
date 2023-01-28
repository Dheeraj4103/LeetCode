import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Twitter {
    List<Users> users;
    int size;
    public Twitter() {
        this.users = new ArrayList<>();
        this.size = 0;
    }
    private class Users{
        int userId;
        List<Tweet> tweets;
        List<Users> following;
        private Users(int userId){
            this.userId = userId;
            tweets = new ArrayList<>();
            following = new ArrayList<>();
        }
    }

    private class Tweet{
        int tweetId;
        static int cnt = 0;
        int time;
        private Tweet(int tweetId){
            cnt++;
            this.tweetId = tweetId;
            this.time = cnt;
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        for (int i = 0; i < users.size(); i++){
            Users user = users.get(i);
            if (user.userId == userId){
                user.tweets.add(new Tweet(tweetId));
                return;
            }
        }

        Users user = new Users(userId);
        user.tweets.add(new Tweet(tweetId));
        users.add(user);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> feeds = new ArrayList<>();
        for (int i = 0; i < this.users.size(); i++){
            Users user = users.get(i);
            if (user.userId == userId){
                feeds.addAll(user.tweets);
                for (Users followee : user.following){
                    feeds.addAll(followee.tweets);
                }
            }
        }

        for (int i = 0; i < feeds.size(); i++){
            for (int j = 1; j < feeds.size()-i; j++){
                if (feeds.get(j).time > feeds.get(j-1).time){
                    Tweet temp = feeds.get(j-1);
                    feeds.set(j-1, feeds.get(j));
                    feeds.set(j, temp);
                }
            }
        }
//        Collections.reverse(feeds);

        List<Integer> newFeeds = new ArrayList<>();
        for (Tweet tweet : feeds){
            newFeeds.add(tweet.tweetId);
        }
        return newFeeds;
    }
    
    public void follow(int followerId, int followeeId) {
        for (int i = 0; i < this.users.size(); i++){
            Users user = users.get(i);
            if (user.userId == followerId){
                for (Users followee : users){
                    if (followee.userId == followeeId && !user.following.contains(followee)){
                        user.following.add(followee);
                        return;
                    }
                }
                Users followee = new Users(followeeId);
                users.add(followee);
                user.following.add(followee);
                return;
            }
        }

        Users user = new Users(followerId);
        for (Users followee : users){
            if (followee.userId == followeeId){
                user.following.add(followee);
                users.add(user);
                return;
            }
        }
        Users followee = new Users(followeeId);
        users.add(followee);
        user.following.add(followee);
        users.add(user);
    }
    
    public void unfollow(int followerId, int followeeId) {
        for (int i = 0; i < this.users.size(); i++){
            Users user = this.users.get(i);
            if (user.userId == followerId){
                for (Users followee : user.following){
                    if (followee.userId == followeeId){
                        user.following.remove(followee);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1,5);
        List<Integer> param_2 = obj.getNewsFeed(1);
        System.out.println(param_2);

//        obj.follow(2,1);
        obj.postTweet(1, 3);
        param_2 = obj.getNewsFeed(1);
        System.out.println(param_2);
//        obj.unfollow(2,1);
//        System.out.println(obj.getNewsFeed(2));
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