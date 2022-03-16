package services.impl;

import models.Question;
import models.User;
import models.UserFeed;
import repositories.IAnswerRepository;
import repositories.IQuestionRepository;
import repositories.impl.AnswerRepository;
import repositories.impl.QuestionRepository;
import services.IUserFeedService;

import java.util.List;

public class UserFeedService implements IUserFeedService {
    IQuestionRepository questionRepository;
    IAnswerRepository answerRepository;

    public UserFeedService(IQuestionRepository questionRepository, IAnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public UserFeed getUserFeed(User user) {
        //fetchTopTenLatestQuestions
        UserFeed feed = new UserFeed(user);
        List<Question> questions = questionRepository.fetchRandomRecords(3);
        for(Question question : questions) {
            feed.add(question, answerRepository.get(question));
        }
        return feed;
    }
}
