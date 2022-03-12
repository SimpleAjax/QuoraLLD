package tests;

import models.Answer;
import models.Comment;
import models.Question;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.IAnswerRepository;
import repositories.ICommentRepository;
import repositories.IQuestionRepository;
import repositories.impl.AnswerRepository;
import repositories.impl.CommentRepository;
import repositories.impl.QuestionRepository;
import services.ICommentService;
import services.IPostService;
import services.impl.CommentService;
import services.impl.PostService;

public class CommentServiceTest {

    User user1, user2, user3, user4, user5;
    IQuestionRepository questionRepository;
    IAnswerRepository answerRepository;
    ICommentRepository commentRepository;
    IPostService postService;
    ICommentService commentService;
    Question question1, question2;
    Answer answer11, answer12;

    @BeforeEach
    public void init() {
        questionRepository = new QuestionRepository();
        answerRepository = new AnswerRepository();
        commentRepository = new CommentRepository();

        commentService = new CommentService(commentRepository);
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
    public void commentOnQuestionAndAnswer() {
        // comment21 on question2 by user 5
        Comment comment21 = new Comment(question2.getId(), user3.getId(), "comment21 content");
        commentService.postComment(comment21);

        // comment112 on answer11 by user 3
        Comment comment112 = new Comment(answer11.getId(), user5.getId(), "comment112 content");
        commentService.postComment(comment112);

        Assertions.assertEquals("comment21 content",
                commentService.getComments(question2.getId()).get(0).getContent());

        Assertions.assertEquals("comment112 content",
                commentService.getComments(answer11.getId()).get(0).getContent());

        Assertions.assertEquals(1, commentService.getComments(question2.getId()).size());
        Assertions.assertEquals(1, commentService.getComments(answer11.getId()).size());

        // comment112 on answer11 by user 4
        Comment comment1124 = new Comment(answer11.getId(), user4.getId(), "comment1124 content");
        commentService.postComment(comment1124);

        Assertions.assertEquals(2, commentService.getComments(answer11.getId()).size());

    }

}
