package repositories.impl;

import models.Answer;
import models.Question;
import models.User;
import repositories.IAnswerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerRepository implements IAnswerRepository {
    Map<String, List<Answer>> questionVsAnswer;
    Map<String, Answer> answerMap;

    public AnswerRepository() {
        questionVsAnswer = new HashMap<>();
        answerMap = new HashMap<>();
    }

    @Override
    public Answer getById(String id) {
        return answerMap.get(id);
    }

    @Override
    public void add(Answer answer) {
        List<Answer> answers = questionVsAnswer.getOrDefault(answer.getQuestion().getId(), new ArrayList<>());
        answers.add(answer);
        questionVsAnswer.put(answer.getQuestion().getId(), answers);
        answerMap.put(answer.getId(), answer);
    }

    @Override
    public void upvote(User user, Answer post) {
        answerMap.get(post.getId()).getVote().addUpvote(user.getId());
    }

    @Override
    public void downvote(User user, Answer post) {
        answerMap.get(post.getId()).getVote().addDownvote(user.getId());
    }

    @Override
    public void removeVoteFor(Answer post) {
        answerMap.get(post.getId()).getVote().removeVote(post.getUser().getId());
    }

    @Override
    public List<Answer> get(Question question) {
        return questionVsAnswer.get(question.getId());
    }

    @Override
    public void printState() {
        System.out.println(answerMap);
    }
}
