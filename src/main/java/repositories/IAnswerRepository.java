package repositories;

import models.Answer;
import models.Question;
import models.User;

import java.util.List;

public interface IAnswerRepository {

    Answer getById(String id);

    void add(Answer answer);

    void upvote(User user, Answer post);

    void downvote(User user, Answer post);

    void removeVoteFor(Answer post);

    List<Answer> get(Question question);

    void printState();
}
