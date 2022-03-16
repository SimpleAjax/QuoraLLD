import models.Answer;
import models.Comment;
import models.Question;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.IAnswerRepository;
import repositories.ICommentRepository;
import repositories.IQuestionRepository;
import services.impl.CommentService;
import services.impl.PostService;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CommentServiceTest {

    User user1, user2, user3, user4, user5;
    @Mock
    IQuestionRepository questionRepository;
    @Mock
    IAnswerRepository answerRepository;
    @Mock
    ICommentRepository commentRepository;

    //TODO: can we only @InjectMock a class and not interface?
    @InjectMocks
    PostService postService;
    @InjectMocks
    CommentService commentService;
    Question question1, question2;
    Answer answer11, answer12;


    @BeforeEach
    public void init() {
        // TODO: does it automatically searches for the argument and passes them as reuiqred?
        initMocks(this);

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
        verify(commentRepository).add(eq(comment21));

        // comment112 on answer11 by user 3
        Comment comment112 = new Comment(answer11.getId(), user5.getId(), "comment112 content");
        commentService.postComment(comment112);
        verify(commentRepository).add(eq(comment112));

        // comment112 on answer11 by user 4
        Comment comment1124 = new Comment(answer11.getId(), user4.getId(), "comment1124 content");
        commentService.postComment(comment1124);
        verify(commentRepository).add(eq(comment1124));

    }

}
