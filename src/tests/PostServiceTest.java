package tests;

import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.IAnswerRepository;
import repositories.IQuestionRepository;
import repositories.impl.AnswerRepository;
import repositories.impl.QuestionRepository;
import services.IPostService;
import services.impl.PostService;

public class PostServiceTest {
    User user1, user2, user3, user4, user5;
    IQuestionRepository questionRepository;
    IAnswerRepository answerRepository;
    IPostService postService;
    Question question1, question2;
    Answer answer11, answer12;
    @BeforeEach
    public void init() {

        questionRepository = new QuestionRepository();
        answerRepository = new AnswerRepository();

        postService = new PostService(questionRepository, answerRepository);

        user1 = new User("user1", "user1");
        user2 = new User("user2", "user2");
        user3 = new User("user3", "user3");
        user4 = new User("user4", "user4");
        user5 = new User("user5", "user5");

        // post question1 by user1
        question1 = new Question("question1", user1,
                "question1 description", "question1 summary");
        postService.postQuestion(question1);

        // post question2 by user2
        question2 = new Question("question2", user2,
                "question2 description", "question2 summary");
        postService.postQuestion(question2);

        // answer11 to question1 by user 3
        answer11 = new Answer("answer11", user3,
                "answer11 description", "answer11 summary", question1);
        postService.postAnswer(answer11);

        // answer12 to question1 by user 2
        answer12 = new Answer("answer12", user2,
                "answer12 description", "answer12 summary", question1);
        postService.postAnswer(answer12);

    }

    @Test
    public void testUpvoteAndDownvoteQuestion() {
        // downvote question2 by user3
        postService.downvotePost(user3, question2);

        // upvote question1 by user1
        postService.upvotePost(user1, question1);

        boolean isUpvoted = question1.getVote().getUpvotes().contains(user1.getId());
        boolean isDownvoted = question2.getVote().getDownvotes().contains(user3.getId());
        Assertions.assertTrue(isUpvoted);
        Assertions.assertTrue(isDownvoted);
    }

    @Test
    public void testUpvoteAndDownvoteAnswer() {
        // upvote answer12 by user 4
        postService.upvotePost(user4, answer12);

        // downvote answer11 by user 5
        postService.downvotePost(user5, answer11);

        boolean isUpvoted = answer12.getVote().getUpvotes().contains(user4.getId());
        boolean isDownvoted = answer11.getVote().getDownvotes().contains(user5.getId());

        Assertions.assertTrue(isUpvoted);
        Assertions.assertTrue(isDownvoted);
    }

}
