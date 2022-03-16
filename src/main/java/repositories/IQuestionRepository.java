package repositories;

import models.Question;
import models.User;

import java.util.List;

public interface IQuestionRepository {

    Question getById(String id);

    void add(Question question);

    List<Question> fetchByUserId(String id);

    void upvote(User user, Question post);

    void downvote(User user, Question post);

    void removeVoteFor(Question post);

    List<Question> fetchRandomRecords(int i);

    void printState();
}
