package models;

import java.util.HashSet;
import java.util.Set;

public class Vote {
    private Set<String> upvotes;
    private Set<String> downvotes;

    public Vote() {
        upvotes = new HashSet<>();
        downvotes = new HashSet<>();
    }

    public Set<String> getUpvotes() {
        return upvotes;
    }

    public Set<String> getDownvotes() {
        return downvotes;
    }

    public void addUpvote(String userId) {
        removeVote(userId);
        upvotes.add(userId);
    }

    public void addDownvote(String userId) {
        removeVote(userId);
        downvotes.add(userId);
    }

    public void removeVote(String userId) {
        downvotes.remove(userId);
        upvotes.remove(userId);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                '}';
    }
}
