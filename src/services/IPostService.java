package services;

import models.Answer;
import models.Post;
import models.Question;
import models.User;

public interface IPostService {
    void postQuestion(Question question);
    void postAnswer(Answer answer);
    void upvotePost(User user, Post post);
    void downvotePost(User user, Post post);
    void removeVote(User user, Post post);
    void printState();
}
