package services.impl;

import models.Answer;
import models.Post;
import models.Question;
import models.User;
import repositories.IAnswerRepository;
import repositories.IQuestionRepository;
import repositories.impl.AnswerRepository;
import repositories.impl.QuestionRepository;
import services.IPostService;

import java.util.List;

public class PostService implements IPostService {

    IQuestionRepository questionRepository;
    IAnswerRepository answerRepository;

    public PostService(IQuestionRepository questionRepository, IAnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    /** Question's Services*/
    public void postQuestion(Question question) {
        questionRepository.add(question);
    }

    public List<Question> getQuestion(User user) {
        return questionRepository.fetchByUserId(user.getId());
    }

    public void postAnswer(Answer answer) {
        answerRepository.add(answer);
    }

    public void upvotePost(User user, Post post) {
        if(post instanceof Question) {
            questionRepository.upvote(user, (Question) post);
        } else if(post instanceof Answer) {
            answerRepository.upvote(user, (Answer) post);
        }
    }

    public void downvotePost(User user, Post post) {
        if(post instanceof Question) {
            questionRepository.downvote(user, (Question) post);
        } else if(post instanceof Answer) {
            answerRepository.downvote(user, (Answer) post);
        }
    }

    public void removeVote(User user, Post post) {
        if(post instanceof Question) {
            questionRepository.removeVoteFor((Question) post);
        } else if(post instanceof Answer) {
            answerRepository.removeVoteFor((Answer) post);
        }
    }

    @Override
    public void printState() {
        System.out.println("printing question repo");
        questionRepository.printState();
        System.out.println("printing answer repo");
        answerRepository.printState();
    }
}
