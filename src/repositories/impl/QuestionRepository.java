package repositories.impl;

import models.Question;
import models.User;
import repositories.IQuestionRepository;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionRepository implements IQuestionRepository {

    Map<String, Question> questionMap;

    public QuestionRepository() {
        questionMap = new HashMap<>();
    }

    @Override
    public Question getById(String id) {
        return questionMap.get(id);
    }

    @Override
    public void add(Question question) {
        questionMap.put(question.getId(), question);
    }

    @Override
    public List<Question> fetchByUserId(String id) {
        List<Question> questions = new ArrayList<>();
        for(String key : questionMap.keySet()) {
            Question q = questionMap.get(key);
            if(q!=null && id.equals(q.getUser().getId())) questions.add(q);
        }
        return questions;
    }

    @Override
    public void upvote(User user, Question post) {
        questionMap.get(post.getId()).getVote().addUpvote(user.getId());
    }

    @Override
    public void downvote(User user, Question post) {
        questionMap.get(post.getId()).getVote().addDownvote(user.getId());
    }

    @Override
    public void removeVoteFor(Question post) {
        questionMap.get(post.getId()).getVote().removeVote(post.getUser().getId());
    }

    @Override
    public List<Question> fetchRandomRecords(int i) {
        List<Question> questions = new ArrayList<Question>(questionMap.values());
        Collections.shuffle(questions);
        return questions.stream().limit(i).collect(Collectors.toList());
    }

    @Override
    public void printState() {
        System.out.println(questionMap);
    }
}
