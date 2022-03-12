package models;

import java.util.*;

public class UserFeed {
    User user;
    Map<Question, List<Answer>> feed;
    public UserFeed(User user) {
        this.user = user;
        feed = new HashMap<>();
    }

    public void add(Question question, List<Answer> answers) {
        feed.put(question, answers);
    }

    public Set<Question> getQuestions() {
        return feed.keySet();
    }

    public List<Answer> getAnswers(Question question) {
        return feed.getOrDefault(question, new ArrayList<>());
    }

    public String toString() {
        return feed.toString();
    }
}
